package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.file.FileUtil;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.Utils;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOImageListScene
  extends AbstractImageListScene
  implements DialogInterface.OnCancelListener, MsgRevokeListener, AbsListView.OnScrollListener
{
  boolean A = false;
  String D;
  String E;
  int F = 1;
  String G;
  int H;
  private int I = 0;
  AIOImageListModel u;
  public ArrayList<AIORichMediaInfo> v = new ArrayList();
  IAIOImageProvider w;
  AIOImageListScene.ProcessTask x;
  long y;
  String z;
  
  public AIOImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.u = ((AIOImageListModel)paramAbstractImageListModel);
    this.w = paramIAIOImageProvider;
    this.z = paramString;
    if (TextUtils.isEmpty(this.z)) {
      this.z = "0";
    }
  }
  
  private int a(File paramFile1, AIOFilePicData paramAIOFilePicData, File paramFile2)
  {
    File localFile = paramAIOFilePicData.c(20);
    paramFile1 = localFile;
    if (localFile == null)
    {
      localFile = paramAIOFilePicData.c(18);
      paramFile1 = localFile;
      if (localFile == null)
      {
        paramFile1 = paramAIOFilePicData.c(16);
        if (paramFile1 == null) {
          break label179;
        }
      }
    }
    long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
    if (paramFile1.length() > l)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_FULL");
      }
      return 22;
    }
    paramAIOFilePicData = new StringBuilder();
    paramAIOFilePicData.append(paramFile1.getName());
    paramAIOFilePicData.append(".jpg");
    paramAIOFilePicData = new File(paramFile2, paramAIOFilePicData.toString());
    if (!FileUtil.a(paramFile1, paramAIOFilePicData))
    {
      if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNABLE");
        }
        return 24;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_UNKNOW");
      }
      return 21;
    }
    ImageUtil.b(this.b, paramAIOFilePicData.getAbsolutePath());
    label179:
    return 20;
  }
  
  private int a(File paramFile1, AIOImageData paramAIOImageData, File paramFile2)
  {
    paramFile1 = paramAIOImageData.c(2);
    if (paramFile1 != null)
    {
      long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
      if (paramFile1.length() > l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_FULL");
        }
        return 22;
      }
      paramAIOImageData = new StringBuilder();
      paramAIOImageData.append(paramFile1.getName());
      paramAIOImageData.append(".jpg");
      paramAIOImageData = new File(paramFile2, paramAIOImageData.toString());
      if (!FileUtil.a(paramFile1, paramAIOImageData))
      {
        if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNABLE");
          }
          return 24;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_UNKNOW");
        }
        return 21;
      }
      ImageUtil.b(this.b, paramAIOImageData.getAbsolutePath());
    }
    return 20;
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    paramIntent = new Bundle(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = AIOUtils.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    paramContext.startActivity(localIntent);
  }
  
  void A()
  {
    ((AIOPhotoListAdapter)this.q).c = this.s;
    if (this.s)
    {
      this.f.setText(2131886471);
      this.j.setVisibility(0);
      int i = B();
      if (i == 1)
      {
        this.g.setEnabled(true);
        this.g.setClickable(true);
        this.h.setEnabled(true);
        this.h.setClickable(true);
        this.i.setEnabled(true);
        this.i.setClickable(true);
      }
      else if (i == 2)
      {
        if (this.v.size() > 1)
        {
          this.g.setEnabled(false);
          this.g.setClickable(false);
          this.h.setEnabled(false);
          this.h.setClickable(false);
        }
        else
        {
          this.g.setEnabled(true);
          this.g.setClickable(true);
          this.h.setEnabled(false);
          this.h.setClickable(false);
        }
        this.i.setEnabled(true);
        this.i.setClickable(true);
      }
      else
      {
        this.g.setEnabled(false);
        this.g.setClickable(false);
        this.h.setEnabled(false);
        this.h.setClickable(false);
        this.i.setEnabled(false);
        this.i.setClickable(false);
      }
    }
    else
    {
      this.f.setText(2131886578);
      this.j.setVisibility(8);
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((GalleryImage)localIterator.next()).setSelected(2);
      }
      this.v.clear();
    }
    this.q.notifyDataSetChanged();
  }
  
  public int B()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((AIORichMediaInfo)this.v.get(0)).a;
      if ((!AIOImageData.class.isInstance(localObject)) && (!AIOFilePicData.class.isInstance(localObject)))
      {
        if (AIOShortVideoData.class.isInstance(localObject)) {
          return 2;
        }
        return 0;
      }
      return 1;
    }
    return 0;
  }
  
  public Rect a()
  {
    int i = this.k.getFirstVisiblePosition();
    int j = this.u.l();
    View localView = this.k.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.q = new AIOPhotoListAdapter(this.b, paramInt, this.u, this.w, this.k);
    this.q.a(this.u);
    return this.q;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showDownloadResult type = ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.m != null) {
      this.m.dismiss();
    }
    this.m = DialogUtil.a(this.b, 230);
    this.m.setOnDismissListener(new AIOImageListScene.2(this));
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        localObject1 = null;
        if (paramInt1 != 3)
        {
          this.m = null;
          return;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showSDCardResult type = ");
          ((StringBuilder)localObject2).append(paramInt2);
          QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramInt2 == 22)
        {
          localObject1 = this.b.getString(2131916080);
          localObject2 = this.b.getString(2131916079);
        }
        else if (paramInt2 == 24)
        {
          localObject1 = this.b.getString(2131916084);
          localObject2 = this.b.getString(2131916083);
        }
        else if (paramInt2 == 23)
        {
          localObject1 = this.b.getString(2131916082);
          localObject2 = this.b.getString(2131916081);
        }
        else
        {
          localObject2 = null;
        }
        this.m = DialogUtil.a(this.b, 230, (String)localObject1, (String)localObject2, null, null);
        this.m.setTitle((String)localObject1);
        this.m.setMessage((CharSequence)localObject2);
        this.m.setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
        this.m.show();
        return;
      }
      this.m.setTitle(String.format(this.b.getResources().getString(2131886525), new Object[] { Integer.valueOf(paramInt2) }));
      this.m.setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
      this.m.show();
      return;
    }
    this.m.setTitle(2131886490);
    Object localObject1 = new AIOImageListScene.3(this, paramInt2);
    this.m.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject1);
    this.m.setPositiveButton(2131916409, (DialogInterface.OnClickListener)localObject1);
    this.m.show();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        a(this.b, paramIntent);
        return;
      }
      if ((99 == paramInt1) || (98 == paramInt1))
      {
        paramIntent = this.v;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext()) {
            ((GalleryImage)paramIntent.next()).setSelected(2);
          }
          this.v.clear();
        }
        if (this.q != null) {
          this.q.notifyDataSetChanged();
        }
        this.s = false;
        if (this.f != null) {
          this.f.setText(2131886578);
        }
        if (this.j != null) {
          this.j.setVisibility(8);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool;
    if ((this.C != null) && (this.C.e() == this)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRevokeMsg seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", current:");
      localStringBuilder.append(bool);
      QLog.d("AIOImageListScene", 2, localStringBuilder.toString());
    }
    this.b.runOnUiThread(new AIOImageListScene.8(this, paramLong, bool));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    Object localObject3 = this.u;
    if (localObject3 == null) {
      return;
    }
    Object localObject1;
    if (paramInt3 == 1) {
      localObject1 = ???;
    } else {
      localObject1 = "I:E";
    }
    int i = ((AIOImageListModel)localObject3).a(paramLong, paramInt1, paramInt2, (String)localObject1, true);
    int j;
    int k;
    if (paramInt2 == 1)
    {
      j = this.k.getFirstVisiblePosition();
      k = this.k.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.k.getChildAt(i - j);
        ((AIOPhotoListAdapter)this.q).a(i, (View)localObject1);
      }
    }
    else if (paramInt2 == 16)
    {
      j = this.k.getFirstVisiblePosition();
      k = this.k.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.k.getChildAt(i - j);
        ((AIOPhotoListAdapter)this.q).a(i, (View)localObject1);
      }
    }
    if (paramInt2 == 2)
    {
      localObject1 = this.x;
      if ((localObject1 != null) && (((AIOImageListScene.ProcessTask)localObject1).c != null) && (((AIOImageListScene.ProcessTask)localObject1).c.a.L == paramLong) && (((AIOImageListScene.ProcessTask)localObject1).c.a.M == paramInt1))
      {
        localObject3 = (AIOImageData)((AIOImageListScene.ProcessTask)localObject1).c.a;
        if (paramInt3 != 1) {
          ??? = "I:E";
        }
        ((AIOImageData)localObject3).b = ???;
        ((AIOImageListScene.ProcessTask)localObject1).c.e = false;
        synchronized (((AIOImageListScene.ProcessTask)localObject1).c)
        {
          ((AIOImageListScene.ProcessTask)localObject1).c.notifyAll();
          return;
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    s();
    super.a(paramViewGroup);
    this.k.setOnScrollListener(this);
  }
  
  void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.b.getResources().getString(2131886578)))
    {
      this.s = true;
      a("Multi_Pic_choose", 0);
      return;
    }
    this.s = false;
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(Integer... paramVarArgs)
  {
    c(paramVarArgs[0].intValue(), 0);
    this.x = new AIOImageListScene.ProcessTask(this, this.v);
    this.x.execute(paramVarArgs);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.f != null))
    {
      a(this.f.getText().toString());
      if (!this.s)
      {
        A();
        return true;
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.ContentHolder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.ContentHolder)localObject).b;
      localObject = ((AIOPhotoListAdapter.ContentHolder)localObject).c;
      int i = paramGalleryImage.getSelected();
      if (i != 1)
      {
        if (i != 2)
        {
          paramView.setVisibility(4);
          ((ImageView)localObject).setVisibility(4);
          return true;
        }
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130847333);
        ((ImageView)localObject).setVisibility(0);
        return true;
      }
      paramView.setVisibility(0);
      ((ImageView)localObject).setImageResource(2130847336);
      ((ImageView)localObject).setVisibility(0);
      return true;
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = B();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.a)) {
        return false;
      }
      if (i == 2) {
        return false;
      }
    }
    int j = paramAIORichMediaInfo.getSelected();
    if (((j == 1) && (paramBoolean1)) || ((j == 2) && (!paramBoolean1))) {
      return false;
    }
    if ((j == 2) && (paramBoolean1) && (this.v.size() >= 20))
    {
      long l = System.currentTimeMillis();
      if (l - this.y >= 700L)
      {
        StringBuilder localStringBuilder;
        if (i == 2)
        {
          paramAIORichMediaInfo = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131898357));
          localStringBuilder.append(20);
          localStringBuilder.append(HardCodeUtil.a(2131898352));
          QQToast.makeText(paramAIORichMediaInfo, 1, localStringBuilder.toString(), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        }
        else
        {
          paramAIORichMediaInfo = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131898347));
          localStringBuilder.append(20);
          localStringBuilder.append(HardCodeUtil.a(2131898351));
          QQToast.makeText(paramAIORichMediaInfo, 1, localStringBuilder.toString(), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        }
        this.y = l;
      }
      return false;
    }
    if ((AIOFilePicData.class.isInstance(paramAIORichMediaInfo.a)) && (paramAIORichMediaInfo.a.c(20) == null) && (paramAIORichMediaInfo.a.c(18) == null) && (paramAIORichMediaInfo.a.c(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramAIORichMediaInfo.setSelected(1);
      this.v.add(paramAIORichMediaInfo);
      return true;
    }
    paramAIORichMediaInfo.setSelected(2);
    this.v.remove(paramAIORichMediaInfo);
    return true;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.l != null)
    {
      this.l.dismiss();
      this.l = null;
    }
    if (paramInt1 != 10)
    {
      if (paramInt1 != 11)
      {
        if (paramInt1 != 30)
        {
          switch (paramInt1)
          {
          default: 
            return;
          case 22: 
          case 23: 
          case 24: 
            a(3, 0);
            return;
          case 21: 
            localActivity = this.b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.b.getResources().getString(2131886522));
            localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
            QQToast.makeText(localActivity, 1, localStringBuilder.toString(), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          Activity localActivity = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.b.getResources().getString(2131886523));
          localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
          QQToast.makeText(localActivity, 2, localStringBuilder.toString(), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        z();
        return;
      }
      a(1, paramInt2);
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgressDialog step = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
    }
    if (this.l == null)
    {
      this.l = new ReportDialog(this.b, 2131953338);
      this.l.setCancelable(true);
      this.l.show();
      this.l.setContentView(2131625585);
      this.l.setOnCancelListener(this);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = (TextView)this.l.findViewById(2131440191);
    if (paramInt1 != 0) {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          break label236;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTextView.getResources().getText(2131886524));
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
        break label236;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTextView.getResources().getText(2131886526));
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    label236:
    localTextView.setText((CharSequence)localObject);
    if (!this.l.isShowing()) {
      this.l.show();
    }
  }
  
  protected void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
    localActionSheet.setMainTitle(2131886527);
    localActionSheet.addButton(2131886528, 5);
    int m = B();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.v.size()) {
        break;
      }
      if (((((AIORichMediaInfo)this.v.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)this.v.get(i)).a).n == null))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131890811);
    }
    if ((this.A) && (m == 1) && (j == 0)) {
      localActionSheet.addButton(2131890805, 5);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new AIOImageListScene.1(this, localActionSheet));
    localActionSheet.show();
    a("Multi_Pic_Forward", this.v.size());
  }
  
  public void k()
  {
    super.k();
    this.v.clear();
    this.v = null;
    this.u = null;
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public void l()
  {
    if (this.q != null)
    {
      this.k.post(new AIOImageListScene.7(this));
      this.d.setText(2131916794);
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = this.v.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject).next();
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
      {
        if (((AIOImageData)localAIORichMediaInfo.a).c(2) == null)
        {
          i = 0;
          break label93;
        }
      }
      else {
        AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a);
      }
    }
    int i = 1;
    label93:
    if (i != 0)
    {
      a(new Integer[] { Integer.valueOf(1) });
    }
    else
    {
      localObject = BaseApplication.getContext();
      boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131892713), "qqsetting_auto_receive_pic_key", true);
      i = NetworkUtil.getNetworkType((Context)localObject);
      if (i == -1) {
        a(1, this.v.size());
      } else if ((!bool) && (i != 1)) {
        a(0, 0);
      } else {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    a("Multi_Pic_Save", this.v.size());
  }
  
  protected void n()
  {
    long[] arrayOfLong = new long[this.v.size()];
    int i = 0;
    while (i < this.v.size())
    {
      if ((this.v.get(i) != null) && (((AIORichMediaInfo)this.v.get(i)).a != null)) {
        arrayOfLong[i] = ((AIORichMediaInfo)this.v.get(i)).a.L;
      }
      i += 1;
    }
    if (this.w.asBinder().pingBinder())
    {
      this.w.b(arrayOfLong);
      QQToast.makeText(this.b, this.b.getString(2131889761), 0).show();
    }
  }
  
  protected AdapterView.OnItemClickListener o()
  {
    return new AIOImageListScene.4(this);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.l = null;
    paramDialogInterface = this.x;
    if (paramDialogInterface != null) {
      paramDialogInterface.b = false;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.k.getLastVisiblePosition();
      int i = this.u.m();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.I != i))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("[onScroll] loadMedias: mLastLoadingCount=");
          paramAbsListView.append(this.I);
          QLog.d("AIOImageListScene", 2, paramAbsListView.toString());
        }
        this.I = i;
        ((AIOPhotoListAdapter)this.q).b(true);
        this.w.a(0);
      }
    }
  }
  
  protected GestureSelectGridView.OnSelectListener p()
  {
    return new AIOImageListScene.5(this);
  }
  
  protected View.OnClickListener q()
  {
    return new AIOImageListScene.6(this);
  }
  
  public void r()
  {
    IAIOImageProvider localIAIOImageProvider = this.w;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(0);
    }
  }
  
  void s()
  {
    this.s = false;
    this.y = 0L;
    Bundle localBundle = this.b.getIntent().getExtras();
    this.A = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.o = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    this.G = localBundle.getString("extra.GROUP_UIN");
    if (this.A)
    {
      this.D = localBundle.getString("extra.GROUP_UIN");
      this.E = localBundle.getString("extra.GROUP_CODE");
      if (((this.D == null) || (this.E == null) || (this.z == null)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mGroupUin=");
        localStringBuilder.append(this.D);
        localStringBuilder.append(", mGroupCode=");
        localStringBuilder.append(this.E);
        localStringBuilder.append(", mMyUin=");
        localStringBuilder.append(this.z);
        QLog.i("AIOImageListScene", 2, localStringBuilder.toString());
      }
    }
    this.F = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.H = localBundle.getInt("forward_source_uin_type", -1);
    this.u.h();
    this.u.p();
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public void t()
  {
    super.t();
    Object localObject = this.u;
    if (localObject != null)
    {
      int j = ((AIOImageListModel)localObject).l();
      int k = this.u.k();
      int i = this.u.j();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStart start FirstVisiblePosition ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" LastVisiblePosition ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" SelectedIndex = ");
        ((StringBuilder)localObject).append(j);
        QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
      }
      if ((j > k) || (j < i) || (j - i < 4))
      {
        if ((k > 0) && (j > k))
        {
          j -= k;
          if ((j > 4) && (j % 4 == 0)) {
            i = i + j + 4;
          } else {
            i = i + j + 8;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onStart selectedIndex > lastPosition n ");
            ((StringBuilder)localObject).append(i);
            QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
          }
          this.k.setSelection(i);
        }
        else
        {
          this.k.setSelection(j);
        }
        this.u.d(this.k.getFirstVisiblePosition());
        this.u.e(this.k.getLastVisiblePosition());
      }
      if (QLog.isColorLevel())
      {
        i = this.u.b();
        j = this.u.k();
        k = this.u.j();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStart end FirstVisiblePosition ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" LastVisiblePosition ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" SelectedIndex = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOImageListScene", 2, "onStart error!! mAIOModel == null ");
    }
  }
  
  void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131892713), "qqsetting_auto_receive_pic_key", true);
    int i;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == -1) {
      j = 1;
    } else {
      j = 0;
    }
    localObject = this.v.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject).next();
      if ((AIOImageData.class.isInstance(localAIORichMediaInfo.a)) && (localAIORichMediaInfo.a.c(2) == null))
      {
        k = 0;
        break label137;
      }
    }
    int k = 1;
    label137:
    if (k != 0)
    {
      z();
      return;
    }
    if (j != 0)
    {
      a(1, this.v.size());
      return;
    }
    if ((!bool) && (i == 0))
    {
      a(0, 1);
      return;
    }
    a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
  }
  
  void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).n);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).o));
      }
    }
    AIOGalleryUtils.a(this.b, this.z, this.D, this.E, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(this.b, this.z, this.E, this.F, (List)this.v.clone(), this.A, this.D);
  }
  
  void z()
  {
    Object localObject1 = this.v;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.v.get(0);
      Object localObject2;
      Object localObject3;
      AIORichMediaInfo localAIORichMediaInfo;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).a;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).b(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).b(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.v.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.v.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898349));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.v.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).b);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) {
            if (((AIOFilePicData)localAIORichMediaInfo.a).c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).e);
            } else if (((AIOFilePicData)localAIORichMediaInfo.a).c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).d);
            } else if (((AIOFilePicData)localAIORichMediaInfo.a).c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).c);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.b, (Intent)localObject2, 1);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).a;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOFilePicData)localObject2).b(18);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).b(16));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.v.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.v.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898350));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        localObject2 = new ArrayList();
        localObject3 = this.v.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).b);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) {
            if (((AIOFilePicData)localAIORichMediaInfo.a).c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).e);
            } else if (((AIOFilePicData)localAIORichMediaInfo.a).c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).d);
            } else if (((AIOFilePicData)localAIORichMediaInfo.a).c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).c);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.b, (Intent)localObject2, 1);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene
 * JD-Core Version:    0.7.0.1
 */