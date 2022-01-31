package com.tencent.mobileqq.arcard;

import aamn;
import aamo;
import aamp;
import aamq;
import aamt;
import aamu;
import aamv;
import aamw;
import aamx;
import aamy;
import aamz;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.SendRecvShareInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class ARGreetingCardListManager
  implements View.OnClickListener, URLDrawable.URLDrawableListener
{
  private static ARGreetingCardListManager jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aamn(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private AREngine jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  private ARCardObserver jdField_a_of_type_ComTencentMobileqqArcardARCardObserver;
  private ARCardPageProcess jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess;
  private ARCardShareHelper jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper;
  private ARGreetingCardListManager.BtnState jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState;
  private ARGreetingCardListManager.GreetingCardItem jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem;
  private ARGreetingCardListManager.RenderProxy jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy;
  private NonMainAppHeadLoader jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader;
  private ScanTorchActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  private Drawable a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = new NonMainAppHeadLoader(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, 1);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(new aamo(this));
    }
    return new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(paramString, true));
  }
  
  public static ARGreetingCardListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager == null) {
      jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager = new ARGreetingCardListManager();
    }
    return jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager;
  }
  
  private String a(File paramFile)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramFile != null)
    {
      localObject1 = localObject2;
      if (paramFile.exists())
      {
        str = paramFile.getAbsolutePath();
        paramFile = new BitmapFactory.Options();
        paramFile.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, paramFile);
        paramFile = paramFile.outMimeType;
        if (!"image/png".equals(paramFile)) {
          break label133;
        }
        paramFile = str + ".png";
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFile))
      {
        if (new File(paramFile).exists()) {
          break label190;
        }
        if (!FileUtils.d(str, paramFile)) {
          break label166;
        }
      }
      label110:
      for (localObject1 = paramFile;; localObject1 = paramFile)
      {
        QLog.d("ARGreetingCardListManager", 2, String.format("convertCacheFileToNormal coverPath=%s", new Object[] { localObject1 }));
        return localObject1;
        if (!"image/jpeg".equals(paramFile)) {
          break label195;
        }
        paramFile = str + ".jpg";
        break;
        QLog.e("ARGreetingCardListManager", 1, String.format("convertCacheFileToNormal fail! copyDestFilePath=%s", new Object[] { paramFile }));
        paramFile = null;
        break label110;
      }
      label133:
      label166:
      label190:
      label195:
      paramFile = null;
    }
  }
  
  private void a(PBRepeatMessageField paramPBRepeatMessageField)
  {
    QLog.d("ARGreetingCardListManager", 2, String.format("addGreetingCardList list=%s", new Object[] { paramPBRepeatMessageField }));
    long l1;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.m).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int k;
        QLog.d("ARGreetingCardListManager", 1, "addGreetingCardList get uin fail.", localException);
        continue;
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
        {
          localException.e = (ARResouceDir.c() + "arcard_guideimage2.png");
          localException.jdField_d_of_type_JavaLangString = (ARResouceDir.c() + "arcard_guidevideo2.mp4");
          ReportController.b(null, "dc00898", "", "", "0X8008F1F", "0X8008F1F", 0, 0, "", "", "", "");
          this.jdField_b_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = localException;
        }
      }
    }
    localObject = new ARGreetingCardListManager.GreetingCardItem(this);
    ((ARGreetingCardListManager.GreetingCardItem)localObject).jdField_a_of_type_Int = 1;
    ((ARGreetingCardListManager.GreetingCardItem)localObject).jdField_a_of_type_Long = l1;
    ((ARGreetingCardListManager.GreetingCardItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.n;
    ((ARGreetingCardListManager.GreetingCardItem)localObject).jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    int j;
    if ((paramPBRepeatMessageField == null) || (paramPBRepeatMessageField.isEmpty()))
    {
      ((ARGreetingCardListManager.GreetingCardItem)localObject).e = (ARResouceDir.c() + "arcard_guideimage1.png");
      ((ARGreetingCardListManager.GreetingCardItem)localObject).jdField_d_of_type_JavaLangString = (ARResouceDir.c() + "arcard_guidevideo1.mp4");
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = ((ARGreetingCardListManager.GreetingCardItem)localObject);
      ReportController.b(null, "dc00898", "", "", "0X8008F17", "0X8008F17", 0, 0, "", "", "", "");
      if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        j = this.jdField_a_of_type_JavaUtilList.size();
        k = paramPBRepeatMessageField.size();
        i = 0;
        while (i < k)
        {
          localObject = (ARRelationShipListPb.SendRecvShareInfo)paramPBRepeatMessageField.get(i);
          if (localObject != null)
          {
            ARGreetingCardListManager.GreetingCardItem localGreetingCardItem = new ARGreetingCardListManager.GreetingCardItem(this);
            localGreetingCardItem.jdField_a_of_type_Long = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint64_from_uin.get();
            localGreetingCardItem.jdField_a_of_type_JavaLangString = ((ARRelationShipListPb.SendRecvShareInfo)localObject).str_to_from_nick.get();
            localGreetingCardItem.jdField_b_of_type_JavaLangString = ((ARRelationShipListPb.SendRecvShareInfo)localObject).str_to_from_remark.get();
            localGreetingCardItem.jdField_b_of_type_Long = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint64_topic_id.get();
            localGreetingCardItem.jdField_c_of_type_Long = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint64_share_id.get();
            localGreetingCardItem.jdField_a_of_type_Int = ((ARRelationShipListPb.SendRecvShareInfo)localObject).enum_content_type.get();
            localGreetingCardItem.jdField_d_of_type_Long = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint64_create_time.get();
            localGreetingCardItem.jdField_b_of_type_Int = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint32_send_recv_flag.get();
            localGreetingCardItem.jdField_c_of_type_JavaLangString = ((ARRelationShipListPb.SendRecvShareInfo)localObject).str_desc.get();
            localGreetingCardItem.jdField_d_of_type_JavaLangString = ((ARRelationShipListPb.SendRecvShareInfo)localObject).str_video_url.get();
            localGreetingCardItem.e = ((ARRelationShipListPb.SendRecvShareInfo)localObject).str_cover_url.get();
            localGreetingCardItem.jdField_c_of_type_Int = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint32_duration.get();
            localGreetingCardItem.jdField_d_of_type_Int = ((ARRelationShipListPb.SendRecvShareInfo)localObject).uint32_size.get();
            this.jdField_a_of_type_JavaUtilList.add(localGreetingCardItem);
          }
          i += 1;
        }
      }
    }
    else if (j == 0)
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label668;
      }
    }
    label668:
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = this.jdField_c_of_type_Int + this.jdField_d_of_type_Int)
    {
      this.jdField_e_of_type_Int = i;
      QLog.d("ARGreetingCardListManager", 2, String.format("addGreetingCardList total length=%s", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }));
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, ARCardCameraRecordActivity.class);
    localIntent.putExtra("currentNickName", this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.e());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("entry_point", i);
      localIntent.putExtra("aio_msg_title", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.h);
      localIntent.putExtra("aio_msg_summary", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.i);
      localIntent.putExtra("aio_msg_imageurl", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.k);
      localIntent.putExtra("aio_msg_url", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.j);
      localIntent.putExtra("card_default_text", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.l);
      localIntent.putExtra("send_msg_success_url", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.f);
      localIntent.putExtra("taskId", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("H5Source", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.startActivity(localIntent);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper = new ARCardShareHelper(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper.a(null);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver = new aamw(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver = null;
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy != null) && (this.jdField_b_of_type_Int < this.jdField_e_of_type_Int - 1))
    {
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.a(a());
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.e();
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1) {
        a(null, -1);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new aamy(this));
      QLog.d("ARGreetingCardListManager", 2, String.format("swipeLeft mCurrentPos=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy != null) && (this.jdField_b_of_type_Int > 0))
    {
      this.jdField_b_of_type_Int -= 1;
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.a(a());
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.f();
      this.jdField_a_of_type_AndroidOsHandler.post(new aamz(this));
      QLog.d("ARGreetingCardListManager", 2, String.format("swipeRight mCurrentPos=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
  }
  
  private void k()
  {
    Object localObject2 = ARGreetingCardListManager.BtnState.EMPTY;
    ARGreetingCardListManager.GreetingCardItem localGreetingCardItem = a(this.jdField_b_of_type_Int);
    Object localObject1 = localObject2;
    label85:
    int i;
    label101:
    int j;
    if (localGreetingCardItem != null)
    {
      this.jdField_a_of_type_Long = localGreetingCardItem.jdField_c_of_type_Long;
      if (localGreetingCardItem.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_Int = 2;
        if (!this.jdField_c_of_type_Boolean) {
          break label413;
        }
        if (this.jdField_b_of_type_Int != -1) {
          break label300;
        }
        localObject1 = ARGreetingCardListManager.BtnState.MASTER_STATE_1;
        this.jdField_b_of_type_AndroidWidgetButton.setText("送AR文字祝福");
        this.jdField_c_of_type_AndroidWidgetButton.setText("送AR视频祝福");
      }
    }
    else
    {
      if ((localObject1 == ARGreetingCardListManager.BtnState.EMPTY) || (localObject1 == ARGreetingCardListManager.BtnState.MASTER_STATE_1)) {
        break label526;
      }
      i = 1;
      localObject2 = this.jdField_b_of_type_AndroidWidgetButton;
      if (i == 0) {
        break label531;
      }
      j = 0;
      label113:
      ((Button)localObject2).setVisibility(j);
      localObject2 = this.jdField_c_of_type_AndroidWidgetButton;
      if (i == 0) {
        break label537;
      }
      i = 0;
      label131:
      ((Button)localObject2).setVisibility(i);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess;
      if ((this.jdField_e_of_type_Int <= 1) || (this.jdField_b_of_type_Int < 0)) {
        break label543;
      }
      i = 0;
      label160:
      ((ARCardPageProcess)localObject2).setVisibility(i);
      if (localObject1 != ARGreetingCardListManager.BtnState.MASTER_STATE_1) {
        break label549;
      }
      i = 1;
      label175:
      localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
      if (i == 0) {
        break label554;
      }
      j = 8;
      label188:
      ((Button)localObject2).setVisibility(j);
      localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (i == 0) {
        break label559;
      }
      i = 0;
      label206:
      ((TextView)localObject2).setVisibility(i);
      if ((localObject1 != ARGreetingCardListManager.BtnState.MASTER_STATE_1) || (VideoEncoderUtils.a())) {
        break label565;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetButton.setText("送AR文字祝福");
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      QLog.d("ARGreetingCardListManager", 2, String.format("updateBtnState state=%s item=%s", new Object[] { localObject1, localGreetingCardItem }));
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState = ((ARGreetingCardListManager.BtnState)localObject1);
      return;
      this.jdField_a_of_type_Int = 3;
      break;
      label300:
      if (localGreetingCardItem.jdField_b_of_type_Int == 1)
      {
        localObject1 = ARGreetingCardListManager.BtnState.MASTER_STATE_2;
        this.jdField_b_of_type_AndroidWidgetButton.setText("发送当前AR贺卡");
        if (VideoEncoderUtils.a())
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText("创建新的AR贺卡");
          break label85;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setText("送AR文字祝福");
        break label85;
      }
      localObject1 = localObject2;
      if (localGreetingCardItem.jdField_b_of_type_Int != 2) {
        break label85;
      }
      localObject1 = ARGreetingCardListManager.BtnState.MASTER_STATE_3;
      this.jdField_b_of_type_AndroidWidgetButton.setText("邀请好友一起玩");
      if (VideoEncoderUtils.a())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText("我要送AR贺卡");
        break label85;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText("送AR文字祝福");
      break label85;
      label413:
      if (localGreetingCardItem.jdField_b_of_type_Int == 1)
      {
        localObject1 = ARGreetingCardListManager.BtnState.GUEST_STATE_1;
        this.jdField_b_of_type_AndroidWidgetButton.setText("发送当前AR贺卡");
        if (VideoEncoderUtils.a())
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText("创建新的AR贺卡");
          break label85;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setText("送AR文字祝福");
        break label85;
      }
      localObject1 = localObject2;
      if (localGreetingCardItem.jdField_b_of_type_Int != 2) {
        break label85;
      }
      localObject1 = ARGreetingCardListManager.BtnState.GUEST_STATE_2;
      this.jdField_b_of_type_AndroidWidgetButton.setText("邀请好友一起玩");
      if (VideoEncoderUtils.a())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText("我要送AR贺卡");
        break label85;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText("送AR文字祝福");
      break label85;
      label526:
      i = 0;
      break label101;
      label531:
      j = 8;
      break label113;
      label537:
      i = 8;
      break label131;
      label543:
      i = 8;
      break label160;
      label549:
      i = 0;
      break label175;
      label554:
      j = 0;
      break label188;
      label559:
      i = 8;
      break label206;
      label565:
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void l()
  {
    ARGreetingCardListManager.GreetingCardItem localGreetingCardItem = a(this.jdField_b_of_type_Int);
    if (localGreetingCardItem != null)
    {
      if (localGreetingCardItem.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    else {
      return;
    }
    Object localObject1 = String.valueOf(localGreetingCardItem.jdField_a_of_type_Long);
    Drawable localDrawable = a((String)localObject1);
    Object localObject2 = localGreetingCardItem.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      localObject2 = new Date(localGreetingCardItem.jdField_d_of_type_Long * 1000L);
      localObject2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      localObject1 = localObject2;
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, ArCardSelectMemberActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_max", 20);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.getString(2131438253));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.getString(2131432417));
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("aio_msg_title", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.h);
    localIntent.putExtra("aio_msg_summary", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.i);
    localIntent.putExtra("aio_msg_imageurl", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.k);
    localIntent.putExtra("aio_msg_url", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.j);
    localIntent.putExtra("send_msg_success_url", this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.f);
    localIntent.putExtra("aio_msg_shareid", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("H5Source", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("param_arcardtype", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.overridePendingTransition(0, 0);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("选择送AR贺卡的方式");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("送AR文字祝福");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("送AR视频祝福");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("取消");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new aamp(this));
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public ARGreetingCardListManager.GreetingCardItem a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public ARGreetingCardListManager.GreetingCardItem a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == -1) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        localObject1 = localObject2;
      } while (paramInt < 0);
      localObject1 = localObject2;
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    return (ARGreetingCardListManager.GreetingCardItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((URLDrawable)this.jdField_a_of_type_JavaUtilMap.get(paramString) == null)
        {
          Object localObject1 = AbsDownloader.a(paramString);
          if ((localObject1 != null) && (((File)localObject1).exists()))
          {
            localObject1 = a((File)localObject1);
            QLog.d("ARGreetingCardListManager", 2, String.format("requestVideoCoverPath videoCoverUrl=%s coverPath=%s", new Object[] { paramString, localObject1 }));
            return localObject1;
          }
          URLDrawable.removeMemoryCacheByUrl(paramString);
          localObject1 = URLDrawable.getDrawable(new URL(paramString), null);
          if (((URLDrawable)localObject1).getStatus() == 1) {
            QLog.w("ARGreetingCardListManager", 2, "requestVideoCoverPath file not found but memory cache exists?");
          }
          ((URLDrawable)localObject1).setURLDrawableListener(this);
          ((URLDrawable)localObject1).startDownload();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
          QLog.d("ARGreetingCardListManager", 2, String.format("requestVideoCoverPath add download map drawable=%s", new Object[] { localObject1 }));
        }
        else
        {
          QLog.d("ARGreetingCardListManager", 2, String.format("requestVideoCoverPath cover is downloading. videoCoverUrl=%s", new Object[] { paramString }));
        }
      }
      catch (Exception localException)
      {
        QLog.e("ARGreetingCardListManager", 1, "requestVideoCoverPath fail.", localException);
      }
      Object localObject2 = null;
    }
  }
  
  public void a()
  {
    QLog.d("ARGreetingCardListManager", 2, "unInit");
    this.jdField_a_of_type_Boolean = false;
    h();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = null;
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardShareHelper = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.b();
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, AREngine paramAREngine, FrameLayout paramFrameLayout, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, boolean paramBoolean3, String paramString3)
  {
    QLog.d("ARGreetingCardListManager", 2, "init");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = paramScanTorchActivity;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = paramAREngine;
    this.jdField_a_of_type_AndroidViewViewGroup = paramFrameLayout;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_g_of_type_Boolean = paramBoolean3;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日 HH:mm");
    this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getDefault());
    g();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramArCloudConfigInfo != null)
      {
        this.jdField_b_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = null;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
        this.jdField_g_of_type_Int = paramInt;
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfByte = null;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = true;
      }
      QLog.d("ARGreetingCardListManager", 2, String.format("requestGreetingCardList mRequestEnd=%s", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
      if (!this.jdField_d_of_type_Boolean)
      {
        QLog.d("ARGreetingCardListManager", 2, String.format("requestGreetingCardList mRequestTaskId=%s mIsMasterState=%s mPromotionUserTo=%s mPromotionShareId=%s mSendRecvFlag=%s", new Object[] { this.jdField_d_of_type_JavaLangString, Boolean.valueOf(this.jdField_c_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_f_of_type_Int) }));
        ((ARRelationShipHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(4)).a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Boolean, 0, 10, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int);
      }
    }
  }
  
  public void a(ARGreetingCardListManager.RenderProxy paramRenderProxy)
  {
    QLog.d("ARGreetingCardListManager", 2, String.format("setRenderProxy renderProxy=%s", new Object[] { paramRenderProxy }));
    this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy = paramRenderProxy;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ARGreetingCardListManager", 2, String.format("setSwipeEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    QLog.d("ARGreetingCardListManager", 2, "initCardListUI");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() == 0)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new aamq(this));
    }
  }
  
  public void c()
  {
    QLog.d("ARGreetingCardListManager", 2, "showCardListUI");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new aamt(this));
    }
  }
  
  public void d()
  {
    QLog.d("ARGreetingCardListManager", 2, "updateCardListUI");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new aamu(this));
    }
  }
  
  public void e()
  {
    QLog.d("ARGreetingCardListManager", 2, "hideCardListUI");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new aamv(this));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aamx(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label383:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy == null);
            this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.g();
            return;
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (this.jdField_a_of_type_JavaUtilList.isEmpty())
            {
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              if (VideoEncoderUtils.a())
              {
                this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
                this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
                this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
                return;
              }
              this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
              return;
            }
            i();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.MASTER_STATE_1)
            {
              ReportController.b(null, "dc00898", "", "", "0X8008F18", "0X8008F18", 1, 0, "", "", "", "");
              b(false);
              return;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.MASTER_STATE_2) || (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.GUEST_STATE_1))
            {
              ReportController.b(null, "dc00898", "", "", "0X8008F1C", "0X8008F1C", 0, 0, "", "", "", "");
              m();
              return;
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.MASTER_STATE_3) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.GUEST_STATE_2));
          if (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.MASTER_STATE_3)
          {
            ReportController.b(null, "dc00898", "", "", "0X8008F1A", "0X8008F1A", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.MASTER_STATE_3) {
              break label383;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            c(bool);
            return;
            ReportController.b(null, "dc00898", "", "", "0X8008F26", "0X8008F26", 0, 0, "", "", "", "");
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.MASTER_STATE_1)
          {
            ReportController.b(null, "dc00898", "", "", "0X8008F19", "0X8008F19", 1, 0, "", "", "", "");
            b(true);
            return;
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.MASTER_STATE_2) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.MASTER_STATE_3) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.GUEST_STATE_1) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.GUEST_STATE_2));
        if (VideoEncoderUtils.a()) {
          n();
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.MASTER_STATE_3) || (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState == ARGreetingCardListManager.BtnState.GUEST_STATE_2))
        {
          ReportController.b(null, "dc00898", "", "", "0X8008F25", "0X8008F25", 0, 0, "", "", "", "");
          return;
          b(false);
        }
        ReportController.b(null, "dc00898", "", "", "0X8008F1E", "0X8008F1E", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$BtnState != ARGreetingCardListManager.BtnState.MASTER_STATE_1);
      ReportController.b(null, "dc00898", "", "", "0X8008F18", "0X8008F18", 1, 0, "", "", "", "");
      b(false);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy == null) || (!this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.c()));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getURL().toString();
    QLog.d("ARGreetingCardListManager", 2, String.format("VideoCover.onLoadCanceled url=%s", new Object[] { paramURLDrawable }));
    this.jdField_a_of_type_JavaUtilMap.remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = paramURLDrawable.getURL().toString();
    QLog.d("ARGreetingCardListManager", 2, String.format("VideoCover.onLoadFialed url=%s", new Object[] { paramURLDrawable }), paramThrowable);
    this.jdField_a_of_type_JavaUtilMap.remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().toString();
    Object localObject = null;
    File localFile = paramURLDrawable.getFileInLocal();
    if (localFile != null) {
      localObject = localFile.getAbsolutePath();
    }
    QLog.d("ARGreetingCardListManager", 2, String.format("VideoCover.onLoadSuccessed url=%s filePath=%s", new Object[] { str, localObject }));
    QLog.d("ARGreetingCardListManager", 2, String.format("VideoCover.onLoadSuccessed remove download map urlDrawable=%s cacheDrawable=%s", new Object[] { paramURLDrawable, (URLDrawable)this.jdField_a_of_type_JavaUtilMap.remove(str) }));
    paramURLDrawable = a(localFile);
    localObject = a(this.jdField_b_of_type_Int);
    if ((localObject != null) && (((ARGreetingCardListManager.GreetingCardItem)localObject).e.equals(str)) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$RenderProxy.a(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARGreetingCardListManager
 * JD-Core Version:    0.7.0.1
 */