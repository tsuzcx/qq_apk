package com.tencent.mobileqq.activity.photo.albumlogicImp;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoConst.Menu;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoSelectedThumbAdapter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.DragView;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarTintManager;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class PhotoPreviewCustomizationAIO
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO";
  public int b = 1052;
  public boolean j = false;
  boolean k = false;
  boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  public boolean o = false;
  private SendByFile p;
  
  PhotoPreviewCustomizationAIO(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  private void d()
  {
    Object localObject4 = this.c.getIntent();
    if (this.d.r)
    {
      ((Intent)localObject4).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      if (this.d.j == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
      else if (this.d.j == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (this.d.j == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
    int i2 = 0;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("custom_photopreview_sendbtn_report", false)))
    {
      localObject3 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      if (localObject1 == null) {
        localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      if (localObject1 == null) {
        localObject1 = "";
      }
      if ((localObject3 != null) && (localObject1 != null)) {
        ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      }
    }
    if ((g()) && (this.d.w > 0))
    {
      localObject1 = this.f.selectedPhotoList.iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.d.z.values().iterator();
        i1 = i;
        for (;;)
        {
          i = i1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject2).equals(localObject4))) {
            i1 += 1;
          }
        }
      }
      localObject1 = new StringBuilder();
      int i1 = i2;
      if (this.f.selectedPhotoList != null) {
        i1 = this.f.selectedPhotoList.size();
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ReportController.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
  }
  
  private void h(int paramInt)
  {
    int i;
    if (this.f.selectedPhotoList.size() >= this.f.maxSelectNum) {
      i = 1;
    } else {
      i = 0;
    }
    int i1;
    if (i != 0) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", i1, 0, "", "", "", "");
    Object localObject2;
    Object localObject1;
    if (i != 0)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.d.C >= 700L)
      {
        localObject2 = this.c;
        if (this.m) {
          localObject1 = this.c.getResources().getString(2131892558, new Object[] { Integer.valueOf(this.f.maxSelectNum) });
        } else {
          localObject1 = s().i();
        }
        QQToast.makeText((Context)localObject2, (CharSequence)localObject1, 1000).show();
        this.d.C = l1;
        if (this.d.v) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      s().m.setChecked(false);
      return;
    }
    if ((paramInt != -1) && (this.d.y.size() > paramInt))
    {
      localObject1 = (String)this.d.y.get(paramInt);
      this.i.c((String)localObject1);
      localObject1 = PresendPicMgr.a(null);
      if ((localObject1 != null) && (!this.d.r) && (this.i.b((String)this.d.y.get(paramInt)) != 1)) {
        ((PresendPicMgr)localObject1).a((String)this.d.y.get(paramInt), this.b);
      }
      localObject1 = (String)this.d.y.get(paramInt);
      this.f.selectedPhotoList.add(localObject1);
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
      localObject2 = this.p;
      if (localObject2 != null)
      {
        NewPhotoPreviewActivity localNewPhotoPreviewActivity = this.c;
        boolean bool;
        if (((PhotoOtherData)this.g).d == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((SendByFile)localObject2).a(localNewPhotoPreviewActivity, (String)localObject1, bool, this.f.selectedMediaInfoHashMap, this.f.allMediaInfoHashMap, true);
      }
    }
    b();
  }
  
  private void i(int paramInt)
  {
    s().m.setChecked(false);
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
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.d.y.get(paramInt), 1014);
        }
      }
    }
    b();
    if ((this.f.selectedIndex.size() == 0) && (!this.d.r)) {
      this.d.t = false;
    }
  }
  
  public Intent a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Intent localIntent = this.c.getIntent();
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("PhotoConst.editPathMap", this.d.z);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      return localIntent;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    RichMediaBrowserInfo localRichMediaBrowserInfo = s().getItem(s().m());
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localRichMediaBrowserInfo != null)
    {
      bool1 = bool2;
      if (localRichMediaBrowserInfo.baseData != null) {
        if (localRichMediaBrowserInfo.baseData.getType() == 101) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    b(bool1);
    if ((this.j) && (this.d.b.size() != 0)) {
      s().g.setVisibility(8);
    }
    if (this.n)
    {
      super.d(8);
      s().m.setVisibility(8);
      s().p.setVisibility(8);
    }
    if (t()) {
      b(this.c.getIntent());
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool;
    if (s().getItem(paramInt).baseData.getType() == 101) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
    super.a(paramInt);
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
      ThreadManager.excute(new PhotoPreviewCustomizationAIO.6(this, str), 64, null, true);
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
        PreviewPictureData localPreviewPictureData = new PreviewPictureData();
        localPreviewPictureData.filePath = str;
        paramIntent.baseData = localPreviewPictureData;
        this.i.b.updateItem(paramIntent, paramInt1);
        this.i.b.setSelectedIndex(paramInt1);
        s().notifyDataSetChanged();
        s().scrollToCurrentPosition();
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null)
        {
          paramIntent.b((String)localObject, 1003);
          paramIntent.a(str, this.b);
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.d.g = true;
    boolean bool2 = false;
    this.j = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.k = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    this.m = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.n = paramIntent.getBooleanExtra("input_full_screen_click", false);
    super.a(paramIntent);
    this.d.v = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.o = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    Object localObject;
    if (this.o)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = PresendPicMgr.a(null);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        ((PresendPicMgr)localObject).a(1003);
      }
      PhotoUtils.sendPhoto(this.c, paramIntent, this.f.selectedPhotoList, ((PhotoOtherData)this.g).d, true);
    }
    if (!this.f.isSingleMode)
    {
      localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).c();
        }
        localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
        this.b = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (this.i.b(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.b);
        }
      }
    }
    this.f.customSendBtnText = this.c.getResources().getString(2131892588);
    if (this.m) {
      this.f.customSendBtnText = this.c.getResources().getString(2131892542);
    }
    StatisticConstants.c();
    if (((PhotoOtherData)this.g).d == 2) {
      this.l = true;
    }
    paramIntent = new SendByFile().a(((PhotoOtherData)this.g).f);
    boolean bool1 = bool2;
    if (!this.k)
    {
      bool1 = bool2;
      if (!this.d.v) {
        bool1 = true;
      }
    }
    this.p = paramIntent.a(bool1);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    Object localObject1 = this.p;
    boolean bool;
    if (localObject1 != null)
    {
      if (((PhotoOtherData)this.g).d == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayList = ((SendByFile)localObject1).a(paramArrayList, bool, this.f.selectedMediaInfoHashMap, this.f.allMediaInfoHashMap);
      ((ArrayList)localPair.first).addAll((Collection)paramArrayList.first);
      ((ArrayList)localPair.second).addAll((Collection)paramArrayList.second);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)localPair.second);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramArrayList);
    }
    int i2;
    try
    {
      i2 = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo)paramIntent.getParcelableExtra("session_info"));
    }
    catch (Exception paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAlbum", 2, "submit", paramArrayList);
      }
      i2 = -1;
    }
    paramArrayList = new HashMap();
    int i4 = 0;
    int i1 = 0;
    int i = 0;
    int i3 = 0;
    while (i4 < ((ArrayList)localPair.first).size())
    {
      localObject1 = (String)((ArrayList)localPair.first).get(i4);
      if (!ImageManager.isNetworkUrl((String)localObject1))
      {
        if (this.i.b((String)localObject1) == 1)
        {
          localObject1 = this.i.c((String)localObject1);
          localObject2 = new SendVideoInfo();
          i += 1;
          ((SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
          ((SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
          paramArrayList.put(Integer.valueOf(i3), localObject2);
        }
        else
        {
          i1 += 1;
        }
        i3 += 1;
      }
      i4 += 1;
    }
    localObject1 = String.valueOf(i1);
    Object localObject2 = String.valueOf(i);
    try
    {
      paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
      if (paramArrayList.isEmpty()) {
        break label411;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    catch (Exception paramArrayList)
    {
      label395:
      break label395;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "put extra Exception");
    }
    label411:
    i = 0;
    if ((SVBusiUtil.c != 0L) && (System.currentTimeMillis() - SVBusiUtil.c < 300000L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("upload video isConfirmed=");
      paramArrayList.append(bool);
      paramArrayList.append(" allowUploadInXGTime=");
      paramArrayList.append(SVBusiUtil.c);
      QLog.d("QQAlbum", 2, paramArrayList.toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!bool) && (i != 0) && (k()))
    {
      paramArrayList = this.c.getResources().getString(2131916238);
      paramIntent = new PhotoPreviewCustomizationAIO.2(this, paramBoolean, paramIntent, localPair, i2, (String)localObject1, (String)localObject2);
      if (FreeWifiHelper.a(this.c, 4, new PhotoPreviewCustomizationAIO.3(this, paramIntent))) {
        DialogUtil.a(this.c, 232, null, paramArrayList, new PhotoPreviewCustomizationAIO.4(this, paramIntent), new PhotoPreviewCustomizationAIO.5(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
    else
    {
      if (paramBoolean)
      {
        ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.c, paramIntent, (ArrayList)localPair.first, this.d.b, ((PhotoOtherData)this.g).d, true);
        this.c.setResult(-1);
        this.c.finish();
      }
      else
      {
        PhotoUtils.sendPhoto(this.c, paramIntent, (ArrayList)localPair.first, ((PhotoOtherData)this.g).d, this.d.e);
      }
      ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", i2, 0, (String)localObject1, (String)localObject2, "", "");
    }
  }
  
  public void a(View paramView)
  {
    this.c.getResources();
    int i = s().m();
    if (this.f.selectedIndex.contains(Integer.valueOf(i))) {
      i(i);
    } else {
      h(i);
    }
    LpReportInfo_pf00064.allReport(603, 2);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    if (this.d.r) {
      this.c.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.a(paramView, 10000, paramBundle, 2, null);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s().h.setChecked(false);
      s().i.setTextColor(2147483647);
      paramCompoundButton = this.p;
      if (paramCompoundButton != null) {
        if (!this.l) {
          paramCompoundButton.a(this.c, this.f.selectedPhotoList, paramBoolean, this.f.selectedMediaInfoHashMap, this.f.allMediaInfoHashMap);
        } else {
          this.l = false;
        }
      }
      ((PhotoOtherData)this.g).d = 2;
      s().j.setChecked(true);
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
    else
    {
      s().i.setTextColor(-1);
      ((PhotoOtherData)this.g).d = 0;
      h();
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = this.f.selectedPhotoList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!NetworkUtils.isNetworkUrl((String)localObject2)) && (this.i.b((String)localObject2) == 1)) {
        paramTextView.setText(this.c.getString(PhotoConst.Menu.e));
      }
    }
    int i = QQAlbumUtils.a(this.f.selectedPhotoList, this.f.allMediaInfoHashMap, true, this.d.b, this.f.selectedMediaInfoHashMap);
    if (i == 0)
    {
      paramTextView.setText(this.c.getString(PhotoConst.Menu.e));
      return;
    }
    localObject1 = PhotoUtils.getRawPhotoSize(this.c, i);
    if ((this.f.selectedPhotoList.size() != 0) && (!((String)localObject1).equals("0")))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c.getString(PhotoConst.Menu.e));
      ((StringBuilder)localObject2).append("(共");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = this.c.getString(PhotoConst.Menu.e);
    }
    paramTextView.setText((CharSequence)localObject1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.r = paramBoolean;
    if (paramBoolean)
    {
      this.d.t = true;
      s().j.setChecked(paramBoolean ^ true);
      s().k.setTextColor(2147483647);
      if ((this.f.selectedPhotoList.isEmpty()) && (s().m() < this.d.y.size()))
      {
        s().n.performClick();
        b();
      }
      if ((s().m() != -1) && (this.d.y.size() > s().m()))
      {
        int i;
        if (this.i.b((String)this.d.y.get(s().m())) != 1) {
          i = 1;
        } else {
          i = 0;
        }
        if ((this.d.s) && (this.c.popup == null) && (i != 0))
        {
          this.d.s = false;
          BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
          this.c.popup = new BubblePopupWindow(-2, -2);
          TextView localTextView = new TextView(this.c);
          i = AIOUtils.b(10.0F, this.c.getResources());
          localTextView.setPadding(i, 0, i, 0);
          localTextView.setTextColor(-1);
          localTextView.setText("选中的图片每人只能查看一次");
          localTextView.setTextSize(14.0F);
          this.c.popup.setContentView(localTextView);
          this.c.popup.setFocusable(false);
          this.c.popup.showAsDropDown(s().i);
        }
      }
      if (this.d.j == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
        return;
      }
      if (this.d.j == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
        return;
      }
      if (this.d.j == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      }
    }
    else
    {
      s().k.setTextColor(-1);
      if (this.c.popup != null) {
        this.c.popup.dismiss();
      }
    }
  }
  
  protected void b(int paramInt)
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (this.f.selectedPhotoList.size() >= this.f.maxSelectNum)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.d.C >= 700L)
      {
        QQToast.makeText(this.c, s().i(), 1000).show();
        this.d.C = l1;
        if (this.d.v) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      s().m.setChecked(false);
      return;
    }
    if (paramInt != -1)
    {
      Object localObject2 = (String)this.d.y.get(paramInt);
      this.i.c((String)localObject2);
      if ((((PhotoOtherData)this.g).d == 2) && (l())) {
        return;
      }
      if ((this.c.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (BaseImageUtil.c((String)localObject2)) && (FileUtils.getFileSizes((String)localObject2) > 3145728L))
      {
        QQToast.makeText(this.c, "图片文件过大", 0).show();
        s().m.setChecked(false);
        return;
      }
      if ((localObject1 != null) && (!this.d.r) && (this.i.b((String)this.d.y.get(paramInt)) != 1)) {
        ((PresendPicMgr)localObject1).a((String)this.d.y.get(paramInt), this.b);
      }
      localObject1 = (String)this.d.y.get(paramInt);
      this.f.selectedPhotoList.add(localObject1);
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
  
  protected void b(Intent paramIntent)
  {
    paramIntent = (Rect)paramIntent.getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i = SystemBarTintManager.getNavigationBarHeight(this.c);
    paramIntent.top -= i;
    paramIntent.bottom -= i;
    s().mDragView.setOriginRect(paramIntent);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.d.j != 0) && (this.d.j != 1) && (this.d.j != 3000))
      {
        f(8);
        return;
      }
      g(8);
      return;
    }
    f(0);
  }
  
  protected void c(int paramInt)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    s().m.setChecked(false);
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
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.d.y.get(paramInt), 1014);
        }
      }
    }
    b();
    if ((this.f.selectedIndex.size() == 0) && (!this.d.r)) {
      this.d.t = false;
    }
  }
  
  void f(int paramInt)
  {
    s().g.setVisibility(paramInt);
    s().j.setVisibility(paramInt);
    s().k.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.d.f)
      {
        s().j.setVisibility(8);
        s().k.setVisibility(8);
      }
      if (!this.d.g) {
        s().g.setVisibility(8);
      }
      if ((this.d.q) && (this.d.d.size() == 0))
      {
        s().h.setVisibility(0);
        s().i.setVisibility(0);
        s().h.setOnCheckedChangeListener(s());
        s().i.setOnClickListener(new PhotoPreviewCustomizationAIO.1(this));
        s().h.setContentDescription("闪照");
        s().i.setContentDescription("闪照");
      }
    }
    else if (s().h.getVisibility() == 0)
    {
      s().h.setVisibility(paramInt);
      s().i.setVisibility(paramInt);
    }
  }
  
  void g(int paramInt)
  {
    s().g.setVisibility(paramInt);
    s().j.setVisibility(0);
    s().k.setVisibility(0);
    if (s().h.getVisibility() != paramInt)
    {
      s().h.setVisibility(paramInt);
      s().i.setVisibility(paramInt);
    }
  }
  
  public boolean g()
  {
    return (this.f.selectedPhotoList != null) && (!this.f.selectedPhotoList.isEmpty());
  }
  
  protected void j()
  {
    d();
    Object localObject1;
    Object localObject2;
    if ("FROM_QZONE_PHOTO_LIST".equals(this.d.A))
    {
      localObject1 = s().l();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1))
      {
        localObject1 = (String)((ArrayList)localObject1).get(0);
        if ((localObject1 != null) && (((String)localObject1).startsWith("http")))
        {
          localObject2 = (PhotoSendParams)this.d.a.get(localObject1);
          if (localObject2 != null) {
            this.d.b.put(localObject1, localObject2);
          }
        }
      }
      if (this.f.selectedPhotoList.size() != 0)
      {
        if (this.c.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {
          localObject1 = (Intent)this.c.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
        } else {
          localObject1 = this.c.getIntent();
        }
        ((Intent)localObject1).setExtrasClassLoader(PeakConstants.class.getClassLoader());
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        a((Intent)localObject1, true, s().l());
      }
    }
    else if (this.m)
    {
      localObject1 = a(s().l());
      if (localObject1 != null)
      {
        this.c.setResult(-1, (Intent)localObject1);
        this.c.finish();
      }
    }
    else
    {
      if (this.d.r) {
        this.c.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      if ((this.d.g) && ((!TextUtils.isEmpty(this.d.o)) || (!TextUtils.isEmpty(this.d.p)))) {
        s().g.performClick();
      }
      localObject1 = s().l();
      localObject2 = this.c.getIntent();
      StatisticConstants.a(((ArrayList)localObject1).size(), this.d.D);
      StatisticConstants.a((Intent)localObject2, ((ArrayList)localObject1).size(), ((PhotoOtherData)this.g).d);
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (((PhotoOtherData)this.g).d == 2)
      {
        if ((this.f.selectedPhotoList.size() == 0) && (((ArrayList)localObject1).size() == 1) && (FileUtils.getFileSizes((String)((ArrayList)localObject1).get(0)) > ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit()))
        {
          QQToast.makeText(this.c, this.c.getResources().getString(2131892570), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
          s().l.setClickable(true);
          return;
        }
        if (localPresendPicMgr != null)
        {
          localPresendPicMgr.a(1010);
          localPresendPicMgr.b();
        }
        ReportController.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
      }
      else if ((localPresendPicMgr != null) && (this.f.selectedPhotoList.size() > 0) && (!this.d.r) && (!this.d.t) && (!this.d.v) && (!((Intent)localObject2).getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.g).a(this.f)))
      {
        localPresendPicMgr.a((Intent)localObject2);
      }
      if (this.d.e) {
        s().d.setVisibility(4);
      }
      NewFlowCameraReporter.a((List)localObject1);
      if (this.d.v)
      {
        ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        ((Intent)localObject2).putExtra("session_info", (SessionInfo)((Intent)localObject2).getParcelableExtra("session_info"));
      }
      a((Intent)localObject2, this.f.containNetImage(), s().l());
    }
  }
  
  protected boolean l()
  {
    Object localObject = (String)this.d.y.get(s().m());
    if (this.i.b((String)localObject) == 1)
    {
      localObject = this.i.c((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        QQToast.makeText(this.c, this.c.getResources().getString(2131916635), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
        AlbumUtil.f();
      }
      return false;
    }
    return super.l();
  }
  
  public boolean t()
  {
    return this.c.getIntent().getBooleanExtra("PHOTO_PREVIEW_NEED_DRAG_KEY", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO
 * JD-Core Version:    0.7.0.1
 */