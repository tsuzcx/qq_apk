package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PhotoListCustomizationAIO
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO";
  boolean i = false;
  boolean j = false;
  boolean k = false;
  boolean l = false;
  boolean m;
  public boolean n = false;
  public HashSet<String> o = new HashSet();
  public HashSet<String> p = new HashSet();
  public SessionInfo q = null;
  private SendByFile r;
  
  PhotoListCustomizationAIO(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private boolean x()
  {
    if (this.e.selectedPhotoList.size() > 0)
    {
      Iterator localIterator = this.e.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.f).a(this.e, str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    List localList = super.a(paramVarArgs);
    this.e.mMediaQueryHelper.upDateCount();
    int i1 = this.e.mMediaQueryHelper.cursorsCount;
    if (i1 >= 1000)
    {
      HashMap localHashMap = new HashMap();
      l1 = System.currentTimeMillis() - l1;
      boolean bool;
      if (this.e.albumName == null) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        paramVarArgs = "1";
      } else {
        paramVarArgs = "0";
      }
      localHashMap.put("isRecent", paramVarArgs);
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("");
      paramVarArgs.append(l1);
      localHashMap.put("duration", paramVarArgs.toString());
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("");
      paramVarArgs.append(i1);
      localHashMap.put("mediaQuantity", paramVarArgs.toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "album_query_media", bool, l1, i1, localHashMap, null);
    }
    return localList;
  }
  
  public void a()
  {
    super.a();
    int i1 = this.e.selectedPhotoList.size();
    boolean bool = true;
    if (i1 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if ((((PhotoOtherData)this.f).g != null) && (((PhotoOtherData)this.f).g.size() > 0) && (this.e.selectedPhotoList.size() == ((PhotoOtherData)this.f).g.size()))
      {
        this.c.magicStickBtn.setEnabled(false);
        return;
      }
      if (x())
      {
        this.c.magicStickBtn.setEnabled(false);
        return;
      }
      TextView localTextView = this.c.magicStickBtn;
      if (this.e.selectedPhotoList.size() != 1) {
        bool = false;
      }
      localTextView.setEnabled(bool);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && ((paramInt1 == 10017) || (paramInt1 == 10018)))
    {
      if (paramInt1 != 10017)
      {
        if (paramInt1 != 10018) {
          return;
        }
        h(paramIntent);
        return;
      }
      paramIntent = g(paramIntent);
      this.c.setResult(-1, paramIntent);
      this.c.finish();
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      this.q = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAlbum", 2, "submit", localException);
      }
    }
    boolean bool2 = false;
    this.j = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.a(paramIntent);
    this.n = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.m = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.m)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = PresendPicMgr.a();
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        ((PresendPicMgr)localObject).a(1004);
      }
      PhotoUtils.sendPhoto(this.c, paramIntent, this.e.selectedPhotoList, ((PhotoOtherData)this.f).d, true);
    }
    this.b.B = true;
    this.e.isSingleMode = false;
    this.b.f = true;
    this.b.d = true;
    this.e.filter.needWebp = true;
    this.i = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.l = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.e.customSendBtnText = this.c.getResources().getString(2131892588);
    if (this.l) {
      this.e.customSendBtnText = this.c.getResources().getString(2131892542);
    }
    if (((PhotoOtherData)this.f).d == 2) {
      this.k = true;
    }
    paramIntent.getIntExtra("uintype", -1);
    Object localObject = new SendByFile().a(((PhotoOtherData)this.f).f);
    boolean bool1 = bool2;
    if (!this.j)
    {
      bool1 = bool2;
      if (!this.n) {
        bool1 = true;
      }
    }
    this.r = ((SendByFile)localObject).a(bool1);
    if ((BinderWarpper)paramIntent.getParcelableExtra("binder_presendService") == null)
    {
      paramIntent = PresendPicMgr.a();
      if (paramIntent != null) {
        paramIntent.c();
      }
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new Pair(new ArrayList(), new ArrayList());
    Object localObject2 = this.r;
    boolean bool2 = false;
    if (localObject2 != null)
    {
      if (((PhotoOtherData)this.f).d == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramArrayList = ((SendByFile)localObject2).a(paramArrayList, bool1, this.e.selectedMediaInfoHashMap, this.e.allMediaInfoHashMap);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
    }
    else
    {
      ((ArrayList)((Pair)localObject1).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject1;
    }
    paramArrayList = (ArrayList)paramArrayList.first;
    int i7 = PhotoUtils.getTypeforReportSpcialDiscuss(this.q);
    localObject1 = new HashMap();
    int i6 = 0;
    int i2 = 0;
    int i1 = 0;
    int i5 = 0;
    while (i6 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i6);
      if (!ImageManager.isNetworkUrl((String)localObject2))
      {
        int i3;
        int i4;
        if (((PhotoOtherData)this.f).a(this.e, (String)localObject2) == 1)
        {
          localObject2 = ((PhotoOtherData)this.f).b(this.e, (String)localObject2);
          i3 = i2;
          i4 = i1;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoInfo();
            ((SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(i5), localObject3);
            i4 = i1 + 1;
            i3 = i2;
          }
        }
        else
        {
          i3 = i2 + 1;
          i4 = i1;
        }
        i5 += 1;
        i1 = i4;
        i2 = i3;
      }
      i6 += 1;
    }
    localObject2 = String.valueOf(i2);
    Object localObject3 = String.valueOf(i1);
    if (!((HashMap)localObject1).isEmpty())
    {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (SVBusiUtil.c != 0L)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - SVBusiUtil.c < 300000L) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload video isConfirmed=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" allowUploadInXGTime=");
      ((StringBuilder)localObject1).append(SVBusiUtil.c);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!bool1) && (i1 != 0))
    {
      localObject1 = this.c.getResources().getString(2131916238);
      paramIntent = new PhotoListCustomizationAIO.1(this, paramBoolean, paramIntent, paramArrayList, i7, (String)localObject2, (String)localObject3);
      if (FreeWifiHelper.a(this.c, 4, new PhotoListCustomizationAIO.2(this, paramIntent))) {
        DialogUtil.a(this.c, 232, null, (String)localObject1, new PhotoListCustomizationAIO.3(this, paramIntent), new PhotoListCustomizationAIO.4(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    if (paramBoolean) {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.c, paramIntent, paramArrayList, this.b.b, ((PhotoOtherData)this.f).d, false);
    } else {
      PhotoUtils.sendPhoto(this.c, paramIntent, paramArrayList, ((PhotoOtherData)this.f).d, this.b.a);
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i7, 0, (String)localObject2, (String)localObject3, "", "");
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.h.t.a(paramInt);
    ArrayList localArrayList = this.e.selectedPhotoList;
    boolean bool = QLog.isColorLevel();
    int i3 = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current select count:");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    int i4 = paramView.selectStatus;
    bool = false;
    int i1;
    if ((i4 != 1) && (localArrayList.size() >= this.e.maxSelectNum)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = 2;
    } else {
      i2 = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", i2, 0, "", "", "", "");
    if (i1 != 0)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.b.H >= 1000L)
      {
        QQToast.makeText(this.c, c(paramView), 0).show();
        paramCheckBox.setChecked(false);
        this.b.H = l1;
        w();
      }
      return;
    }
    if ((this.l) && (paramView.fileSize > 31457280L))
    {
      QQToast.makeText(this.c, 2131892589, 0).show();
      paramCheckBox.setChecked(false);
      return;
    }
    if (i4 == 1) {
      i1 = i3;
    } else {
      i1 = 1;
    }
    paramView.selectStatus = i1;
    if (paramView.selectStatus == 1) {
      bool = true;
    }
    if (bool) {
      d(paramView);
    } else {
      e(paramView);
    }
    this.h.a(paramInt, bool);
    this.h.b(bool ^ true);
    a();
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.e.selectedPhotoList.size() > 0) {
      i(this.c.getIntent());
    }
    super.a(paramView, paramBundle, paramInt, paramIntent);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = this.r;
      if (paramCompoundButton != null) {
        if (!this.k) {
          paramCompoundButton.a(this.c, this.e.selectedPhotoList, paramBoolean, this.e.selectedMediaInfoHashMap, this.e.allMediaInfoHashMap);
        } else {
          this.k = false;
        }
      }
      ((PhotoOtherData)this.f).d = 2;
      this.c.qualityCheckBox.setChecked(true);
      this.c.qualityCountTv.setVisibility(0);
      f();
    }
    else
    {
      ((PhotoOtherData)this.f).d = 0;
      this.c.qualityCheckBox.setChecked(false);
      this.c.qualityCountTv.setVisibility(4);
    }
    if (!this.b.e) {
      this.c.qualityCountTv.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramInt2);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.f).a(this.e, str) != 1) {
          localPresendPicMgr.a(str, 1052);
        }
      }
      localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        localPresendPicMgr.b((String)localIterator.next(), 1013);
      }
    }
    this.o.clear();
    this.p.clear();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    paramIntent.putExtra("input_full_screen_mode", this.l);
    super.a(paramBoolean, paramIntent);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = super.a(paramLocalMediaInfo, paramBoolean);
    if (bool)
    {
      if (paramBoolean)
      {
        String str = paramLocalMediaInfo.path;
        SendByFile localSendByFile = this.r;
        if (localSendByFile != null)
        {
          NewPhotoListActivity localNewPhotoListActivity = this.c;
          paramLocalMediaInfo = paramLocalMediaInfo.path;
          if (((PhotoOtherData)this.f).d == 2) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localSendByFile.a(localNewPhotoListActivity, paramLocalMediaInfo, paramBoolean, this.e.selectedMediaInfoHashMap, this.e.allMediaInfoHashMap, true);
        }
        if (this.p.contains(str)) {
          this.p.remove(str);
        }
        this.o.add(str);
        return bool;
      }
      if (this.o.contains(paramLocalMediaInfo.path))
      {
        this.o.remove(paramLocalMediaInfo.path);
        return bool;
      }
      this.p.add(paramLocalMediaInfo.path);
      return bool;
    }
    w();
    return bool;
  }
  
  public Intent b(View paramView, int paramInt)
  {
    Object localObject = this.c.getIntent();
    ((Intent)localObject).putExtra("key_pic_to_edit_from", 3);
    ((Intent)localObject).putExtra("input_full_screen_mode", this.l);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e.selectedPhotoList.size());
    ((StringBuilder)localObject).append("");
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, ((StringBuilder)localObject).toString(), "", "", "");
    if (this.h.t.a(paramInt).selectStatus != 1)
    {
      int i1;
      if (this.e.selectedPhotoList.size() >= this.e.maxSelectNum) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i1, 0, "", "", "", "");
    }
    return super.b(paramView, paramInt);
  }
  
  public void b(Intent paramIntent)
  {
    if (this.l)
    {
      this.c.startActivityForResult(paramIntent, 10017);
      return;
    }
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    Object localObject = this.q;
    int i1;
    if (localObject != null)
    {
      i1 = PhotoUtils.getTypeforReport2((SessionInfo)localObject);
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X800A916", "0X800A916", i1, 0, "", "", "", "");
    }
    localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    localObject = this.c.getIntent();
    if (this.e.selectedPhotoList != null) {
      i1 = this.e.selectedPhotoList.size();
    } else {
      i1 = 0;
    }
    StatisticConstants.b((Intent)localObject, i1);
    super.b(paramView);
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int i2 = this.e.maxSelectNum;
    paramLocalMediaInfo = this.c.getResources();
    int i1;
    if (this.l) {
      i1 = 2131892558;
    } else {
      i1 = 2131892559;
    }
    return paramLocalMediaInfo.getString(i1, new Object[] { Integer.valueOf(i2) });
  }
  
  protected void c()
  {
    Intent localIntent = this.c.getIntent();
    if ((this.i) && (((PhotoOtherData)this.f).g != null) && (((PhotoOtherData)this.f).g.size() > 0))
    {
      if (this.e.albumId.equals("$RecentAlbumId")) {
        StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      } else if ((!this.e.albumName.equalsIgnoreCase("Camera")) && (!this.e.albumName.equalsIgnoreCase("camera")) && (!this.e.albumName.contains("Camera")) && (!this.e.albumName.contains("camera"))) {
        StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      } else {
        StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      }
      a(localIntent, true, this.e.selectedPhotoList);
      return;
    }
    if (this.l)
    {
      localIntent = d();
      this.c.setResult(-1, localIntent);
      e();
      return;
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (((PhotoOtherData)this.f).d == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.b();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    else if ((localPresendPicMgr != null) && (!this.n) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.f).a(this.e)))
    {
      localPresendPicMgr.a(localIntent);
    }
    if (this.e.selectedPhotoList != null)
    {
      StatisticConstants.a(this.c.getIntent(), this.e.selectedPhotoList.size());
      StatisticConstants.a(this.c.getIntent(), this.e.selectedPhotoList.size(), ((PhotoOtherData)this.f).d);
      NewFlowCameraReporter.a(this.e.selectedPhotoList);
    }
    super.c();
    i(localIntent);
  }
  
  public void c(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.q;
    if (localSessionInfo != null)
    {
      int i1 = PhotoUtils.getTypeforReport2(localSessionInfo);
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X800A915", "0X800A915", i1, 0, "", "", "", "");
    }
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
    paramView = new StringBuilder();
    paramView.append(this.e.selectedPhotoList.size());
    paramView.append("");
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, paramView.toString(), "", "", "");
  }
  
  public void c(View paramView, int paramInt)
  {
    if (this.h.t.a(paramInt).selectStatus != 1)
    {
      int i1;
      if (this.e.selectedPhotoList.size() >= this.e.maxSelectNum) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i1, 0, "", "", "", "");
    }
    super.c(paramView, paramInt);
  }
  
  public Intent d()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.e.selectedPhotoList);
    localIntent.putStringArrayListExtra("input_full_screen_mode_result", localArrayList);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", ((PhotoOtherData)this.f).d);
    return localIntent;
  }
  
  protected void d(Intent paramIntent)
  {
    if (this.l)
    {
      this.c.startActivityForResult(paramIntent, 10018);
      return;
    }
    super.d(paramIntent);
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    Object localObject = this.r;
    if (localObject != null)
    {
      NewPhotoListActivity localNewPhotoListActivity = this.c;
      boolean bool;
      if (((PhotoOtherData)this.f).d == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((SendByFile)localObject).a(localNewPhotoListActivity, str, bool, this.e.selectedMediaInfoHashMap, this.e.allMediaInfoHashMap, true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckBoxSelected:path:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",mMimeType:");
      ((StringBuilder)localObject).append(paramLocalMediaInfo.mMimeType);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    localObject = PresendPicMgr.a();
    if ((localObject != null) && (AlbumUtil.getMediaType(paramLocalMediaInfo) == 0)) {
      ((PresendPicMgr)localObject).a(str, 1052, this.c.getIntent().getIntExtra("entrance", 0));
    }
    super.d(paramLocalMediaInfo);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b(str, 1013);
    }
    super.e(paramLocalMediaInfo);
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    StatisticConstants.a(this.c.getIntent(), "param_totalSelNum");
    Intent localIntent = this.c.getIntent();
    if (!localIntent.hasExtra("param_initTime")) {
      localIntent.putExtra("param_initTime", System.currentTimeMillis());
    }
    super.f(paramLocalMediaInfo);
  }
  
  public Intent g(Intent paramIntent)
  {
    Object localObject1 = (HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap");
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (this.e.selectedPhotoList.contains(str))
        {
          int i1 = this.e.selectedPhotoList.indexOf(str);
          this.e.selectedPhotoList.add(i1, ((Map.Entry)localObject2).getValue());
          this.e.selectedPhotoList.remove(i1 + 1);
        }
      }
    }
    localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    if (this.e.selectedPhotoList.size() > 0)
    {
      ((ArrayList)localObject2).addAll(this.e.selectedPhotoList);
    }
    else
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        ((ArrayList)localObject2).addAll(paramIntent);
      }
    }
    ((Intent)localObject1).putStringArrayListExtra("input_full_screen_mode_result", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", ((PhotoOtherData)this.f).d);
    return localObject1;
  }
  
  protected void g(LocalMediaInfo paramLocalMediaInfo)
  {
    super.g(paramLocalMediaInfo);
    StatisticConstants.a(this.c.getIntent(), "param_cancelSelNum");
  }
  
  public void h(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    String str2 = paramIntent.getStringExtra("key_multi_edit_source_path");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(str2, str1);
      ReplacePhotoDataUtil.a(this.c, this.b.s, localHashMap);
      ((PhotoOtherData)this.f).d = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      int i1 = this.e.selectedPhotoList.indexOf(str2);
      if (i1 >= 0)
      {
        this.e.selectedPhotoList.add(i1, str1);
        this.e.selectedPhotoList.remove(i1 + 1);
      }
    }
  }
  
  public void i(Intent paramIntent)
  {
    if (this.n)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", (SessionInfo)this.c.getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void w()
  {
    if (this.n) {
      ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO
 * JD-Core Version:    0.7.0.1
 */