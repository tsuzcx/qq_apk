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
  long jdField_a_of_type_Long;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  AIOImageListScene.ProcessTask jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<AIORichMediaInfo> a;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString;
  
  public AIOImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
  }
  
  private int a(File paramFile1, AIOFilePicData paramAIOFilePicData, File paramFile2)
  {
    File localFile = paramAIOFilePicData.a(20);
    paramFile1 = localFile;
    if (localFile == null)
    {
      localFile = paramAIOFilePicData.a(18);
      paramFile1 = localFile;
      if (localFile == null)
      {
        paramFile1 = paramAIOFilePicData.a(16);
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
    ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAIOFilePicData.getAbsolutePath());
    label179:
    return 20;
  }
  
  private int a(File paramFile1, AIOImageData paramAIOImageData, File paramFile2)
  {
    paramFile1 = paramAIOImageData.a(2);
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
      ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAIOImageData.getAbsolutePath());
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
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
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
  
  protected View.OnClickListener a()
  {
    return new AIOImageListScene.6(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected AdapterView.OnItemClickListener a()
  {
    return new AIOImageListScene.4(this);
  }
  
  protected GestureSelectGridView.OnSelectListener a()
  {
    return new AIOImageListScene.5(this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new AIOImageListScene.2(this));
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        localObject1 = null;
        if (paramInt1 != 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
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
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718579);
          localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718578);
        }
        else if (paramInt2 == 24)
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718583);
          localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718582);
        }
        else if (paramInt2 == 23)
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718581);
          localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718580);
        }
        else
        {
          localObject2 = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject1, (String)localObject2, null, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689884), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131689849);
    Object localObject1 = new AIOImageListScene.3(this, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, (DialogInterface.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        a(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
        return;
      }
      if ((99 == paramInt1) || (98 == paramInt1))
      {
        paramIntent = this.jdField_a_of_type_JavaUtilArrayList;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext()) {
            ((GalleryImage)paramIntent.next()).setSelected(2);
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
          this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
        }
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689937);
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() == this)) {
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
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOImageListScene.8(this, paramLong, bool));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
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
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject1);
      }
    }
    else if (paramInt2 == 16)
    {
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject1);
      }
    }
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask;
      if ((localObject1 != null) && (((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo != null) && (((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong) && (((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt1))
      {
        localObject3 = (AIOImageData)((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramInt3 != 1) {
          ??? = "I:E";
        }
        ((AIOImageData)localObject3).jdField_b_of_type_JavaLangString = ???;
        ((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_Boolean = false;
        synchronized (((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo)
        {
          ((AIOImageListScene.ProcessTask)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.notifyAll();
          return;
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    q();
    super.a(paramViewGroup);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
  }
  
  void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689937)))
    {
      this.jdField_b_of_type_Boolean = true;
      a("Multi_Pic_choose", 0);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(Integer... paramVarArgs)
  {
    c(paramVarArgs[0].intValue(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask = new AIOImageListScene.ProcessTask(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask.execute(paramVarArgs);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      if (!this.jdField_b_of_type_Boolean)
      {
        w();
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
      paramView = ((AIOPhotoListAdapter.ContentHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((AIOPhotoListAdapter.ContentHolder)localObject).jdField_b_of_type_AndroidWidgetImageView;
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
        ((ImageView)localObject).setImageResource(2130845863);
        ((ImageView)localObject).setVisibility(0);
        return true;
      }
      paramView.setVisibility(0);
      ((ImageView)localObject).setImageResource(2130845866);
      ((ImageView)localObject).setVisibility(0);
      return true;
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = a();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
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
    if ((j == 2) && (paramBoolean1) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 20))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 700L)
      {
        StringBuilder localStringBuilder;
        if (i == 2)
        {
          paramAIORichMediaInfo = this.jdField_a_of_type_AndroidAppActivity;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131700317));
          localStringBuilder.append(20);
          localStringBuilder.append(HardCodeUtil.a(2131700312));
          QQToast.a(paramAIORichMediaInfo, 1, localStringBuilder.toString(), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
        }
        else
        {
          paramAIORichMediaInfo = this.jdField_a_of_type_AndroidAppActivity;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131700307));
          localStringBuilder.append(20);
          localStringBuilder.append(HardCodeUtil.a(2131700311));
          QQToast.a(paramAIORichMediaInfo, 1, localStringBuilder.toString(), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
        }
        this.jdField_a_of_type_Long = l;
      }
      return false;
    }
    if ((AIOFilePicData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramAIORichMediaInfo.setSelected(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAIORichMediaInfo);
      return true;
    }
    paramAIORichMediaInfo.setSelected(2);
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIORichMediaInfo);
    return true;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
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
            localActivity = this.jdField_a_of_type_AndroidAppActivity;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689881));
            localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
            QQToast.a(localActivity, 1, localStringBuilder.toString(), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
            return;
          }
          Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689882));
          localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
          QQToast.a(localActivity, 2, localStringBuilder.toString(), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        v();
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
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646);
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
        localStringBuilder.append(localTextView.getResources().getText(2131689883));
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
        break label236;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTextView.getResources().getText(2131689885));
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    label236:
    localTextView.setText((CharSequence)localObject);
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new AIOImageListScene.7(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719242);
    }
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = null;
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  protected void k()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localActionSheet.setMainTitle(2131689886);
    localActionSheet.addButton(2131689887, 5);
    int m = a();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      if (((((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).e == null))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131693263);
    }
    if ((this.jdField_c_of_type_Boolean) && (m == 1) && (j == 0)) {
      localActionSheet.addButton(2131693257, 5);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new AIOImageListScene.1(this, localActionSheet));
    localActionSheet.show();
    a("Multi_Pic_Forward", this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject).next();
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2) == null)
        {
          i = 0;
          break label93;
        }
      }
      else {
        AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
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
      boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131694986), "qqsetting_auto_receive_pic_key", true);
      i = NetworkUtil.getNetworkType((Context)localObject);
      if (i == -1) {
        a(1, this.jdField_a_of_type_JavaUtilArrayList.size());
      } else if ((!bool) && (i != 1)) {
        a(0, 0);
      } else {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    a("Multi_Pic_Save", this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void m()
  {
    super.m();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (localObject != null)
    {
      int j = ((AIOImageListModel)localObject).f();
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.d();
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
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
      }
      if (QLog.isColorLevel())
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e();
        k = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.d();
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
  
  protected void o()
  {
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        arrayOfLong[i] = ((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(arrayOfLong);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692690), 0).a();
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask;
    if (paramDialogInterface != null) {
      paramDialogInterface.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_d_of_type_Int != i))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("[onScroll] loadMedias: mLastLoadingCount=");
          paramAbsListView.append(this.jdField_d_of_type_Int);
          QLog.d("AIOImageListScene", 2, paramAbsListView.toString());
        }
        this.jdField_d_of_type_Int = i;
        ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(0);
      }
    }
  }
  
  public void p()
  {
    IAIOImageProvider localIAIOImageProvider = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(0);
    }
  }
  
  void q()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString == null)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mGroupUin=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(", mGroupCode=");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(", mMyUin=");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("AIOImageListScene", 2, localStringBuilder.toString());
      }
    }
    this.jdField_b_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_c_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131694986), "qqsetting_auto_receive_pic_key", true);
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
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject).next();
      if ((AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) == null))
      {
        k = 0;
        break label137;
      }
    }
    int k = 1;
    label137:
    if (k != 0)
    {
      v();
      return;
    }
    if (j != 0)
    {
      a(1, this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
    }
    if ((!bool) && (i == 0))
    {
      a(0, 1);
      return;
    }
    a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localArrayList1.add(((AIOImageData)localObject).jdField_a_of_type_JavaLangString);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, (List)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_c_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  void v()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Object localObject2;
      Object localObject3;
      AIORichMediaInfo localAIORichMediaInfo;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700309));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
            } else if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
            } else if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOFilePicData)localObject2).a(18);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700310));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
            } else if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
            } else if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
    }
  }
  
  void w()
  {
    ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689830);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      int i = a();
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
      }
      else if (i == 2)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_c_of_type_AndroidWidgetImageView.setClickable(false);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689937);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((GalleryImage)localIterator.next()).setSelected(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene
 * JD-Core Version:    0.7.0.1
 */