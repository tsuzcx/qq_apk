package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoConst.Menu;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PhotoPreviewCustomizationDefault
  extends PhotoPreviewCustomizationBase<PhotoOtherData>
{
  protected NewPhotoPreviewActivity c;
  protected PhotoPreviewData d;
  
  public PhotoPreviewCustomizationDefault(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
    this.c = ((NewPhotoPreviewActivity)paramAbstractPhotoPreviewActivity);
    this.h = new PhotoPreviewData();
    this.d = ((PhotoPreviewData)this.h);
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.c.getResources();
    if ((s().n != null) && (s().m != null)) {
      s().n.setAccessibilityDelegate(new PhotoPreviewCustomizationDefault.2(this));
    }
    s().q = ((Resources)localObject).getDisplayMetrics().widthPixels;
    s().r = ((Resources)localObject).getDisplayMetrics().heightPixels;
    this.c.selectedPhotoListView = ((HorizontalListView)s().e.findViewById(2131433484));
    this.c.selectedPhotoListDivider = s().e.findViewById(2131433482);
    this.c.selectedPhotoAdapter = new NewPhotoSelectedThumbAdapter(this);
    this.c.selectedPhotoAdapter.a(this.f.selectedPhotoList);
    if (this.c.selectedPhotoListView != null)
    {
      this.c.selectedPhotoListView.setAdapter(this.c.selectedPhotoAdapter);
      this.c.selectedPhotoListView.setOnItemClickListener(this.c.selectedPhotoAdapter);
    }
    if (g())
    {
      if (this.c.selectedPhotoListView != null) {
        this.c.selectedPhotoListView.setVisibility(0);
      }
      if (this.c.selectedPhotoListDivider != null) {
        this.c.selectedPhotoListDivider.setVisibility(0);
      }
    }
    if (this.d.x)
    {
      if (s().d != null) {
        s().d.setVisibility(0);
      }
      if (s().e != null) {
        s().e.setVisibility(0);
      }
    }
    if ((s().h != null) && (this.d.q) && (this.d.d.size() == 0))
    {
      s().h.setVisibility(0);
      s().i.setVisibility(0);
      s().h.setOnCheckedChangeListener(s());
      s().i.setOnClickListener(new PhotoPreviewCustomizationDefault.3(this));
      s().h.setContentDescription("闪照");
      s().i.setContentDescription("闪照");
    }
    if (s().j != null)
    {
      s().j.setOnCheckedChangeListener(s());
      if (this.d.f) {
        s().j.setVisibility(0);
      } else {
        s().j.setVisibility(8);
      }
    }
    if (s().k != null) {
      if (this.d.f) {
        s().k.setVisibility(0);
      } else {
        s().k.setVisibility(8);
      }
    }
    if (s().g != null)
    {
      if (this.d.g) {
        s().g.setVisibility(0);
      } else {
        s().g.setVisibility(8);
      }
      s().g.setOnClickListener(new PhotoPreviewCustomizationDefault.4(this));
    }
    if (s().l != null) {
      s().l.setOnClickListener(new PhotoPreviewCustomizationDefault.5(this));
    }
    b();
    if ((s().m != null) && ((this.d.l) || (this.f.isSingleMode))) {
      s().m.setVisibility(8);
    }
    if (s().j != null)
    {
      if ((this.d.l) || (this.f.isSingleMode)) {
        s().j.setVisibility(8);
      }
      if (this.d.j == 1001) {
        s().j.setVisibility(8);
      }
    }
    if ((s().n != null) && ((this.d.l) || (this.f.isSingleMode))) {
      s().n.setVisibility(8);
    }
    if (s().k != null)
    {
      if ((this.d.l) || (this.f.isSingleMode)) {
        s().k.setVisibility(8);
      }
      if (this.d.j == 1001) {
        s().k.setVisibility(8);
      }
    }
    f();
    if (s().g != null)
    {
      float f = this.c.getResources().getDisplayMetrics().density;
      localObject = s().g;
      int i = (int)(f * 10.0F + 0.5F);
      BaseAIOUtils.a((View)localObject, i, i, i, i);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onItemSelected position=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    super.a(paramInt);
    Object localObject = s().getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
    {
      StringBuilder localStringBuilder;
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100)
      {
        localObject = s().c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("照片");
        localStringBuilder.append(paramInt);
        ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
        return;
      }
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 101)
      {
        if (this.c.popup != null) {
          this.c.popup.dismiss();
        }
        localObject = s().c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("视频");
        localStringBuilder.append(paramInt);
        ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false) ^ true;
      if (!bool) {
        return;
      }
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (str == null) {
        return;
      }
      ThreadManager.excute(new PhotoPreviewCustomizationDefault.6(this, str), 64, null, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResultForMultiEdit hasEdit:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", picPath:");
        ((StringBuilder)localObject).append(str);
        QLog.i("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.d.y.indexOf(localObject);
      if (paramInt1 >= 0)
      {
        if (this.d.z.containsValue(localObject)) {
          paramIntent = ReplacePhotoDataUtil.a(this.d.z, (String)localObject);
        } else {
          paramIntent = (Intent)localObject;
        }
        this.d.z.put(paramIntent, str);
        this.d.y.add(paramInt1, str);
        this.d.y.remove(paramInt1 + 1);
        paramInt2 = this.f.selectedPhotoList.indexOf(localObject);
        if (paramInt2 >= 0)
        {
          this.f.selectedPhotoList.add(paramInt2, str);
          this.f.selectedPhotoList.remove(paramInt2 + 1);
        }
        this.c.selectedPhotoAdapter.notifyDataSetChanged();
        paramIntent = new RichMediaBrowserInfo();
        localObject = new PreviewPictureData();
        ((PreviewPictureData)localObject).filePath = str;
        paramIntent.baseData = ((RichMediaBaseData)localObject);
        this.i.b.updateItem(paramIntent, paramInt1);
        this.i.b.setSelectedIndex(paramInt1);
        s().notifyDataSetChanged();
        s().scrollToCurrentPosition();
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject;
    if (((PhotoOtherData)this.g).e == null)
    {
      localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject != null) {
        ((PhotoOtherData)this.g).e = ((AppRuntime)localObject).getAccount();
      }
    }
    this.d.F = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    super.a(paramIntent);
    this.d.s = MobileQQ.getContext().getSharedPreferences(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.d.q = paramIntent.getBooleanExtra("showFlashPic", false);
    this.d.u = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.d.h = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.d.a = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.d.c = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.d.z = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.d.z == null) {
      this.d.z = new HashMap();
    }
    this.d.d = new HashMap(1);
    if (this.d.c != null) {
      this.d.d.putAll(this.d.c);
    }
    this.d.b = new HashMap(1);
    if (this.d.a != null) {
      this.d.b.putAll(this.d.a);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mCanUseURL:");
      ((StringBuilder)localObject).append(this.d.F);
      ((StringBuilder)localObject).append(" mSelectedSendParams size:");
      ((StringBuilder)localObject).append(this.d.b.size());
      QLog.d("aioSendPhotos", 2, ((StringBuilder)localObject).toString());
    }
    this.f.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.d.e = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.d.f = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.d.g) {
      this.d.g = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.d.A)) {
      this.d.g = false;
    }
    if (this.d.g)
    {
      this.d.n = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.d.o = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.d.p = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.d.j = paramIntent.getIntExtra("uintype", -1);
    this.d.k = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.d.l = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    ((PhotoOtherData)this.g).d = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.d.w = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        if (this.i.b((String)localObject) == 1)
        {
          localObject = this.i.c((String)localObject);
          if (localObject != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            localHashMap.put(Integer.valueOf(j), localSendVideoInfo);
          }
        }
        j += 1;
      }
      i += 1;
    }
    try
    {
      if (localHashMap.isEmpty()) {
        break label169;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    catch (Exception localException)
    {
      label153:
      label169:
      break label153;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "put extra Exception");
    }
    if (paramBoolean)
    {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.c, paramIntent, paramArrayList, this.d.b, ((PhotoOtherData)this.g).d, true);
      this.c.setResult(-1);
      this.c.finish();
      return;
    }
    ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.c, paramIntent, paramArrayList, ((PhotoOtherData)this.g).d, this.d.e);
  }
  
  public void a(View paramView)
  {
    this.c.getResources();
    int i = s().m();
    if (this.f.selectedIndex.contains(Integer.valueOf(i))) {
      c(i);
    } else {
      b(i);
    }
    LpReportInfo_pf00064.allReport(603, 2);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = s().m();
    if ((i != -1) && (this.d.y.size() > i))
    {
      paramView = this.d;
      paramView.m = ((String)paramView.y.get(i));
      if (this.d.m != null)
      {
        ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.d.g)
        {
          paramView = ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(this.c, paramIntent, this.d.m, paramInt2, paramBundle);
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
          if (!this.d.r) {
            paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.d.u);
          }
          if (paramInt1 == -1) {
            this.c.startActivity(paramView);
          } else {
            this.c.startActivityForResult(paramView, paramInt1);
          }
          paramView = s().g;
          paramInt1 = 0;
          if (paramView != null) {
            s().g.setClickable(false);
          }
          paramView = this.c.getIntent();
          if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
          {
            paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
            if (paramView != null) {
              ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
          if ((g()) && (this.d.w > 0))
          {
            paramInt2 = this.d.w;
            paramView = new StringBuilder();
            if (this.f.selectedPhotoList != null) {
              paramInt1 = this.f.selectedPhotoList.size();
            }
            paramView.append(paramInt1);
            paramView.append("");
            ReportController.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramView.toString(), "", "", "");
          }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
      }
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (s().h != null)
      {
        s().h.setChecked(paramBoolean ^ true);
        s().i.setTextColor(2147483647);
      }
      if (QQAlbumUtils.a(this.f.selectedPhotoList, ((PhotoOtherData)this.g).f, this.f.allMediaInfoHashMap, true, this.f.selectedMediaInfoHashMap) > 0)
      {
        paramCompoundButton = this.c;
        QQToast.makeText(paramCompoundButton, paramCompoundButton.getResources().getString(2131892570), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
        ((PhotoOtherData)this.g).d = 0;
        s().k.setText(this.c.getString(PhotoConst.Menu.e));
        s().j.setChecked(false);
        return;
      }
      if (this.f.selectedPhotoList.isEmpty())
      {
        int j = s().m();
        if (j < this.d.y.size())
        {
          long l = new File((String)this.d.y.get(j)).length();
          int i;
          if (this.i.b((String)this.d.y.get(j)) == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i == 0) && (l > ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit()))
          {
            paramCompoundButton = this.c;
            QQToast.makeText(paramCompoundButton, paramCompoundButton.getResources().getString(2131892570), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
            ((PhotoOtherData)this.g).d = 0;
            s().k.setText(this.c.getString(PhotoConst.Menu.e));
            s().j.setChecked(false);
            return;
          }
          s().a("", 1);
          this.f.selectedPhotoList.add(this.d.y.get(j));
          this.f.selectedIndex.add(Integer.valueOf(j));
          s().j.setChecked(true);
          ((PhotoOtherData)this.g).d = 2;
          a(s().k);
          b();
          paramCompoundButton = this.c.getIntent();
          if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
          {
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
            if (paramCompoundButton != null) {
              ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        s().j.setChecked(true);
        ((PhotoOtherData)this.g).d = 2;
        a(s().k);
        paramCompoundButton = this.c.getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
      }
    }
    else
    {
      if (s().j != null) {
        s().j.setChecked(false);
      }
      if (s().k != null)
      {
        ((PhotoOtherData)this.g).d = 0;
        s().k.setText(this.c.getString(PhotoConst.Menu.e));
      }
      if (s().i != null) {
        s().i.setTextColor(-1);
      }
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = this.c.getResources();
    Object localObject2 = this.f.selectedPhotoList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if ((!QAlbumUtil.isNetUrl((String)localObject3)) && (this.i.b((String)localObject3) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(PhotoConst.Menu.e));
      }
    }
    int i = QQAlbumUtils.a(this.f.selectedPhotoList, this.f.allMediaInfoHashMap, false, this.d.b, this.f.selectedMediaInfoHashMap);
    localObject2 = QQAlbumUtils.a(this.c, i);
    if ((this.f.selectedPhotoList.size() != 0) && (!((String)localObject2).equals("0")))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(PhotoConst.Menu.e));
      ((StringBuilder)localObject3).append("(共");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(")");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject1 = ((Resources)localObject1).getString(PhotoConst.Menu.e);
    }
    paramTextView.setText((CharSequence)localObject1);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = this.c.getResources();
    if (this.d.f) {
      localObject = ((Resources)localObject).getString(2131892588);
    } else {
      localObject = ((Resources)localObject).getString(2131892542);
    }
    int i;
    if ((this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((!this.d.l) && (!this.f.isSingleMode))
      {
        if (s().l != null)
        {
          s().l.setEnabled(true);
          Button localButton = s().l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("(");
          localStringBuilder.append(this.f.selectedPhotoList.size());
          localStringBuilder.append(")");
          localButton.setText(localStringBuilder.toString());
        }
        h();
      }
      else if (s().l != null)
      {
        s().l.setEnabled(true);
        s().l.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (s().l != null) {
        s().l.setText((CharSequence)localObject);
      }
      if (s().j != null)
      {
        s().j.setOnCheckedChangeListener(null);
        localObject = s().j;
        if (((PhotoOtherData)this.g).d == 2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((CheckBox)localObject).setChecked(bool1);
        s().j.setOnCheckedChangeListener(s());
      }
      if ((s().k != null) && (((PhotoOtherData)this.g).d == 2)) {
        s().k.setTextColor(-16734752);
      }
      h();
    }
    boolean bool1 = this.f.selectedIndex.contains(Integer.valueOf(s().m()));
    if (s().g != null) {
      if ((s().m() != -1) && (this.d.y.size() > s().m()))
      {
        int j;
        if (this.i.b((String)this.d.y.get(s().m())) != 1) {
          j = 1;
        } else {
          j = 0;
        }
        boolean bool2 = QAlbumUtil.isNetUrl((String)this.d.y.get(s().m()));
        if (((i == 0) || (bool1)) && (j != 0) && (!bool2)) {
          s().g.setEnabled(true);
        } else {
          s().g.setEnabled(false);
        }
      }
      else
      {
        s().g.setEnabled(false);
      }
    }
    if (this.c.selectedPhotoAdapter != null) {
      if (g())
      {
        if ((this.c.selectedPhotoListView != null) && (this.c.selectedPhotoListView.getVisibility() == 4))
        {
          this.c.selectedPhotoListDivider.setVisibility(0);
          this.c.selectedPhotoListView.setVisibility(0);
        }
        this.c.selectedPhotoAdapter.notifyDataSetChanged();
      }
      else if (this.c.selectedPhotoListView != null)
      {
        this.c.selectedPhotoListDivider.setVisibility(4);
        this.c.selectedPhotoListView.setVisibility(4);
      }
    }
    if (s().m != null)
    {
      if ((!bool1) && (this.f.selectedPhotoList.size() >= this.f.maxSelectNum))
      {
        s().m.setActivated(true);
        return;
      }
      s().m.setActivated(false);
    }
  }
  
  protected void b(int paramInt)
  {
    Object localObject1;
    if (this.f.selectedPhotoList.size() >= this.f.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.d.C >= 700L)
      {
        QQToast.makeText(this.c, s().i(), 1000).show();
        localObject1 = this.d;
        ((PhotoPreviewData)localObject1).C = l;
        if (((PhotoPreviewData)localObject1).v) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      s().m.setChecked(false);
      return;
    }
    if (paramInt != -1)
    {
      localObject1 = (String)this.d.y.get(paramInt);
      if ((((PhotoOtherData)this.g).d == 2) && (l())) {
        return;
      }
      if ((this.c.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (BaseImageUtil.c((String)localObject1)) && (FileUtils.getFileSizes((String)localObject1) > 3145728L))
      {
        QQToast.makeText(this.c, "图片文件过大", 0).show();
        s().m.setChecked(false);
        return;
      }
      localObject1 = (String)this.d.y.get(paramInt);
      this.f.selectedPhotoList.add(localObject1);
      Object localObject2;
      if (this.d.a != null)
      {
        localObject2 = (PhotoSendParams)this.d.a.get(localObject1);
        if ((this.d.b != null) && (localObject2 != null)) {
          this.d.b.put(localObject1, localObject2);
        }
      }
      if (this.d.c != null)
      {
        localObject2 = (PicInfo)this.d.c.get(localObject1);
        if ((this.d.d != null) && (localObject2 != null)) {
          this.d.d.put(localObject1, localObject2);
        }
      }
      this.f.selectedIndex.add(Integer.valueOf(paramInt));
      s().a((String)localObject1);
    }
    b();
  }
  
  public void c()
  {
    if ((this.d.E == 103) && (this.d.y != null)) {}
    try
    {
      Object localObject = (String)this.d.y.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        MQLruCache localMQLruCache = GlobalImageCache.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("#short_video_camera_preview_cache");
        localObject = localMQLruCache.remove(localStringBuilder.toString());
        if ((localObject instanceof Bitmap))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "recycle short video preview cache");
          }
          localObject = (Bitmap)localObject;
          if (!((Bitmap)localObject).isRecycled()) {
            ((Bitmap)localObject).recycle();
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label118:
      break label118;
    }
    super.c();
  }
  
  protected void c(int paramInt)
  {
    int i = this.f.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.f.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.f.selectedPhotoList.remove(this.d.y.get(paramInt));
        if (this.d.d != null) {
          this.d.d.remove(this.d.y.get(paramInt));
        }
        if (this.d.b != null) {
          this.d.b.remove(this.d.y.get(paramInt));
        }
      }
    }
    b();
    if ((this.f.selectedIndex.size() == 0) && (!this.d.r)) {
      this.d.t = false;
    }
  }
  
  public void d(int paramInt)
  {
    s().e.setVisibility(paramInt);
  }
  
  protected PhotoOtherData e()
  {
    return new PhotoPreviewCustomizationDefault.1(this);
  }
  
  protected void f()
  {
    float f2 = 16.0F / FontSettingManager.getFontLevel();
    int i = this.c.getResources().getDisplayMetrics().densityDpi;
    int j = 0;
    if ((i >= 400) && (Build.VERSION.SDK_INT > 21)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((f2 < 1.0F) || (i != 0))
    {
      float f1 = f2;
      if (i != 0) {
        f1 = f2 * 0.7F;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("need scale,reqWidth:");
        ((StringBuilder)localObject).append(s().q);
        ((StringBuilder)localObject).append(" scale:");
        ((StringBuilder)localObject).append(f1);
        QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      if (s().f != null) {
        while (j < s().f.getChildCount())
        {
          localObject = s().f.getChildAt(j);
          ((View)localObject).setScaleX(f1);
          ((View)localObject).setScaleY(f1);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          if (j == s().f.getChildCount() - 1)
          {
            localMarginLayoutParams.rightMargin = ((int)(localMarginLayoutParams.rightMargin * f1));
          }
          else
          {
            localMarginLayoutParams.leftMargin = ((int)(localMarginLayoutParams.leftMargin * f1));
            if ((i != 0) && (f1 < 1.0F)) {
              localMarginLayoutParams.leftMargin = ((int)(localMarginLayoutParams.leftMargin * f1));
            }
          }
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
          j += 1;
        }
      }
    }
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void h()
  {
    int i = ((PhotoOtherData)this.g).d;
    if (i != 0)
    {
      if (i != 2) {
        return;
      }
      if (s().k != null) {
        a(s().k);
      }
      if (s().j != null) {
        s().j.setChecked(true);
      }
    }
    else
    {
      if (s().k != null) {
        s().k.setText(this.c.getString(PhotoConst.Menu.e));
      }
      if (s().j != null) {
        s().j.setChecked(false);
      }
    }
  }
  
  public void i()
  {
    Intent localIntent1 = this.c.getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.d.u);
    if ("FROM_PHOTO_LIST".equals(this.d.A))
    {
      localIntent1.setClass(this.c, NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      if (this.f.isSingleMode)
      {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      else
      {
        localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f.selectedPhotoList);
        localIntent1.putExtra("PhotoConst.editPathMap", this.d.z);
      }
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.d.b);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.d.d);
      this.c.startActivity(localIntent1);
    }
    else if ("FROM_QZONE_PHOTO_LIST".equals(this.d.A))
    {
      Intent localIntent2 = new Intent();
      localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f.selectedPhotoList);
      localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.d.b);
      localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f.selectedMediaInfoHashMap);
      this.c.setResult(-1, localIntent2);
    }
    if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
    {
      localIntent1 = new Intent();
      localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f.selectedPhotoList);
      localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.f.selectedIndex);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      localIntent1.putExtra("PhotoConst.editPathMap", this.d.z);
      this.c.setResult(-1, localIntent1);
    }
    this.c.finish();
  }
  
  protected void j()
  {
    if ((s().g != null) && (this.d.g) && ((!TextUtils.isEmpty(this.d.o)) || (!TextUtils.isEmpty(this.d.p)))) {
      s().g.performClick();
    }
    s().l();
    Intent localIntent = this.c.getIntent();
    if (this.d.e) {
      s().d.setVisibility(4);
    }
    a(localIntent, this.f.containNetImage(), s().l());
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected boolean l()
  {
    return false;
  }
  
  protected int m()
  {
    if (this.d.w == 1) {
      return 141;
    }
    if ((this.d.w != 2) && (this.d.w != 3)) {
      return 99;
    }
    return 143;
  }
  
  public void n()
  {
    super.n();
    QQLiveImage.onForeground(this.c);
    SmallScreenUtils.a(MobileQQ.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(MobileQQ.getContext(), false);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(MobileQQ.getContext(), 2, false);
    if (s().g != null) {
      s().g.setClickable(true);
    }
  }
  
  public void o()
  {
    super.o();
    if (this.c.popup != null) {
      this.c.popup.dismiss();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10000)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    QQAlbumUtils.a(this.c, paramInt1, paramInt2, paramIntent, this.d.k, ((PhotoOtherData)this.g).e);
  }
  
  public void p()
  {
    super.p();
  }
  
  public Class q()
  {
    return NewPhotoListActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
 * JD-Core Version:    0.7.0.1
 */