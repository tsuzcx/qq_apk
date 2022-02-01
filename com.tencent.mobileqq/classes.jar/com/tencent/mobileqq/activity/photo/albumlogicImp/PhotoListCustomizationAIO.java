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
  public SessionInfo a;
  private SendByFile jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
  public HashSet<String> a;
  boolean jdField_a_of_type_Boolean = false;
  public HashSet<String> b;
  boolean b;
  boolean c;
  boolean d = false;
  boolean e;
  public boolean f = false;
  
  PhotoListCustomizationAIO(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    localIntent.putStringArrayListExtra("input_full_screen_mode_result", localArrayList);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    return localIntent;
  }
  
  public Intent a(Intent paramIntent)
  {
    Object localObject1 = (HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap");
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(str))
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(str);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(i, ((Map.Entry)localObject2).getValue());
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(i + 1);
        }
      }
    }
    localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)
    {
      ((ArrayList)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    else
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        ((ArrayList)localObject2).addAll(paramIntent);
      }
    }
    ((Intent)localObject1).putStringArrayListExtra("input_full_screen_mode_result", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    return localObject1;
  }
  
  public Intent a(View paramView, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    ((Intent)localObject).putExtra("key_pic_to_edit_from", 3);
    ((Intent)localObject).putExtra("input_full_screen_mode", this.d);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    ((StringBuilder)localObject).append("");
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, ((StringBuilder)localObject).toString(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt).selectStatus != 1)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
    }
    return super.a(paramView, paramInt);
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    paramLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources();
    int i;
    if (this.d) {
      i = 2131694855;
    } else {
      i = 2131694856;
    }
    return paramLocalMediaInfo.getString(i, new Object[] { Integer.valueOf(j) });
  }
  
  public List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    List localList = super.a(paramVarArgs);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.upDateCount();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.cursorsCount;
    if (i >= 1000)
    {
      HashMap localHashMap = new HashMap();
      l = System.currentTimeMillis() - l;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName == null) {
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
      paramVarArgs.append(l);
      localHashMap.put("duration", paramVarArgs.toString());
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("");
      paramVarArgs.append(i);
      localHashMap.put("mediaQuantity", paramVarArgs.toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "album_query_media", bool, l, i, localHashMap, null);
    }
    return localList;
  }
  
  public void a()
  {
    super.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    boolean bool = true;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaUtilHashMap != null) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn.setEnabled(false);
        return;
      }
      if (a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn.setEnabled(false);
        return;
      }
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 1) {
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
        g(paramIntent);
        return;
      }
      paramIntent = a(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAlbum", 2, "submit", localException);
      }
    }
    boolean bool2 = false;
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.a(paramIntent);
    this.f = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.e = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.e)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.a(1004);
      }
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.needWebp = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.d = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694885);
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694839);
    }
    if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new SendByFile().a(((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).b);
    boolean bool1 = bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.f) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile = paramIntent.a(bool1);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new Pair(new ArrayList(), new ArrayList());
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
    boolean bool2 = false;
    if (localObject2 != null)
    {
      if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramArrayList = ((SendByFile)localObject2).a(paramArrayList, bool1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
    }
    else
    {
      ((ArrayList)((Pair)localObject1).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject1;
    }
    paramArrayList = (ArrayList)paramArrayList.first;
    int i2 = PhotoUtils.getTypeforReportSpcialDiscuss(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = new HashMap();
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject2))
      {
        int k;
        int m;
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject2) == 1)
        {
          localObject2 = ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject2);
          k = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoInfo();
            ((SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(n), localObject3);
            m = i + 1;
            k = j;
          }
        }
        else
        {
          k = j + 1;
          m = i;
        }
        n += 1;
        i = m;
        j = k;
      }
      i1 += 1;
    }
    localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty())
    {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
      i = 1;
    }
    else
    {
      i = 0;
    }
    boolean bool1 = bool2;
    if (SVBusiUtil.b != 0L)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - SVBusiUtil.b < 300000L) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload video isConfirmed=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" allowUploadInXGTime=");
      ((StringBuilder)localObject1).append(SVBusiUtil.b);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!bool1) && (i != 0))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131718735);
      paramIntent = new PhotoListCustomizationAIO.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
      if (FreeWifiHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 4, new PhotoListCustomizationAIO.2(this, paramIntent))) {
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 232, null, (String)localObject1, new PhotoListCustomizationAIO.3(this, paramIntent), new PhotoListCustomizationAIO.4(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    if (paramBoolean) {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, false);
    } else {
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, paramArrayList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Boolean);
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    boolean bool = QLog.isColorLevel();
    int k = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current select count:");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    int m = paramView.selectStatus;
    bool = false;
    int i;
    if ((m != 1) && (localArrayList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = 2;
    } else {
      j = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
    if (i != 0)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b >= 1000L)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, a(paramView), 0).a();
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b = l;
        d();
      }
      return;
    }
    if ((this.d) && (paramView.fileSize > 31457280L))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 2131694886, 0).a();
      paramCheckBox.setChecked(false);
      return;
    }
    if (m == 1) {
      i = k;
    } else {
      i = 1;
    }
    paramView.selectStatus = i;
    if (paramView.selectStatus == 1) {
      bool = true;
    }
    if (bool) {
      c(paramView);
    } else {
      d(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(paramInt, bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b(bool ^ true);
    a();
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) {
      h(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent());
    }
    super.a(paramView, paramBundle, paramInt, paramIntent);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      if (paramCompoundButton != null) {
        if (!this.jdField_c_of_type_Boolean) {
          paramCompoundButton.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
        } else {
          this.jdField_c_of_type_Boolean = false;
        }
      }
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.qualityCheckBox.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.qualityCountTv.setVisibility(0);
      e();
    }
    else
    {
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.qualityCheckBox.setChecked(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.qualityCountTv.setVisibility(4);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.qualityCountTv.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramInt2);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, str) != 1) {
          localPresendPicMgr.a(str, 1052);
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        localPresendPicMgr.b((String)localIterator.next(), 1013);
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    paramIntent.putExtra("input_full_screen_mode", this.d);
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
        SendByFile localSendByFile = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
        if (localSendByFile != null)
        {
          NewPhotoListActivity localNewPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
          paramLocalMediaInfo = paramLocalMediaInfo.path;
          if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localSendByFile.a(localNewPhotoListActivity, paramLocalMediaInfo, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, true);
        }
        if (this.jdField_b_of_type_JavaUtilHashSet.contains(str)) {
          this.jdField_b_of_type_JavaUtilHashSet.remove(str);
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(str);
        return bool;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path))
      {
        this.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
        return bool;
      }
      this.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
      return bool;
    }
    d();
    return bool;
  }
  
  protected void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if ((this.jdField_a_of_type_Boolean) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaUtilHashMap != null) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      } else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("camera"))) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      } else {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      }
      a(localIntent, true, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      return;
    }
    if (this.d)
    {
      localIntent = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, localIntent);
      c();
      return;
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    else if ((localPresendPicMgr != null) && (!this.f) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData)))
    {
      localPresendPicMgr.a(localIntent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)
    {
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    super.b();
    h(localIntent);
  }
  
  public void b(Intent paramIntent)
  {
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult(paramIntent, 10017);
      return;
    }
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i;
    if (localObject != null)
    {
      i = PhotoUtils.getTypeforReport2((SessionInfo)localObject);
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b((Intent)localObject, i);
    super.b(paramView);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt).selectStatus != 1)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
    }
    super.b(paramView, paramInt);
  }
  
  public void c(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localSessionInfo != null)
    {
      int i = PhotoUtils.getTypeforReport2(localSessionInfo);
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    paramView.append("");
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, paramView.toString(), "", "", "");
  }
  
  protected void c(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
    if (localObject != null)
    {
      NewPhotoListActivity localNewPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      boolean bool;
      if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((SendByFile)localObject).a(localNewPhotoListActivity, str, bool, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, true);
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
      ((PresendPicMgr)localObject).a(str, 1052, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getIntExtra("entrance", 0));
    }
    super.c(paramLocalMediaInfo);
  }
  
  public void d()
  {
    if (this.f) {
      ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  protected void d(Intent paramIntent)
  {
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult(paramIntent, 10018);
      return;
    }
    super.d(paramIntent);
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b(str, 1013);
    }
    super.d(paramLocalMediaInfo);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent(), "param_totalSelNum");
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (!localIntent.hasExtra("param_initTime")) {
      localIntent.putExtra("param_initTime", System.currentTimeMillis());
    }
    super.e(paramLocalMediaInfo);
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    super.f(paramLocalMediaInfo);
    StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent(), "param_cancelSelNum");
  }
  
  public void g(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    String str2 = paramIntent.getStringExtra("key_multi_edit_source_path");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(str2, str1);
      ReplacePhotoDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaUtilHashMap, localHashMap);
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(str2);
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(i, str1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(i + 1);
      }
    }
  }
  
  public void h(Intent paramIntent)
  {
    if (this.f)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getParcelableExtra("session_info"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO
 * JD-Core Version:    0.7.0.1
 */