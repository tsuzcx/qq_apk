package com.tencent.biz.pubaccount.readinjoy.ugc;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import auea;
import avlz;
import avmh;
import avnw;
import azlo;
import bdee;
import bisl;
import bkzi;
import bkzz;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.os.MqqHandler;
import olh;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import oxf;
import pqf;
import prp;
import ptj;
import pvj;
import pvm;
import pvq;
import rtg;
import rth;
import rtr;
import rts;
import rtu;
import rtv;
import rtw;
import rtx;
import rty;
import rtz;
import rua;
import rub;
import rud;
import rue;
import rur;
import rvy;

public class ReadInJoyDeliverUGCActivity
  extends ReadInJoyBaseDeliverActivity
{
  public static Drawable a;
  private float jdField_a_of_type_Float;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ReadInJoyDeliverUGCActivity.DeliverData jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData = new ReadInJoyDeliverUGCActivity.DeliverData();
  private ReadInJoyNinePicDeliverDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  pvq jdField_a_of_type_Pvq = new rtu(this);
  private rud jdField_a_of_type_Rud = new rud(this);
  private rur jdField_a_of_type_Rur;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private bisl jdField_b_of_type_Bisl;
  private ArrayList<SocializeFeedsInfo.BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private bkzi jdField_c_of_type_Bkzi;
  private List<rue> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List<TransferRequest> d;
  private String jdField_e_of_type_JavaLangString = "";
  private List<String> jdField_e_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private String f;
  private String g;
  private String h;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = 40000;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
  }
  
  public ReadInJoyDeliverUGCActivity()
  {
    this.jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_o_of_type_Int = 0;
  }
  
  private int a()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return 3;
    }
    if ((b() != 0) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 4;
      }
      return 1;
    }
    if ((b() != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  public static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      if (paramHotPicData.getDataType() != 2) {
        break label65;
      }
    }
    label65:
    for (paramHotPicData = avnw.a((HotVideoData)paramHotPicData);; paramHotPicData = avlz.a(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label76;
      }
      return null;
      bool = false;
      break;
    }
    label76:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  private String a(int paramInt)
  {
    String str = pqf.c();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("save", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return str;
  }
  
  private String a(Object paramObject)
  {
    String str = this.jdField_e_of_type_JavaLangString;
    if ((this.jdField_e_of_type_JavaLangString.equals(paramObject)) || (!(paramObject instanceof String))) {
      paramObject = str;
    }
    do
    {
      do
      {
        return paramObject;
        str = (String)paramObject;
        paramObject = str;
      } while (TextUtils.isEmpty(str));
      paramObject = str;
    } while (!new File(str).exists());
    return HexUtil.bytes2HexStr(auea.e(str));
  }
  
  @Nullable
  private String a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof HotPicData))
    {
      a((HotPicData)paramObject, paramInt);
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!a(str));
    return null;
    x();
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("https://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        paramString = paramString.substring(paramString.lastIndexOf(".") + 1);
        if (paramLong2 == paramLong1)
        {
          olh.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.jdField_d_of_type_Int), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, pqf.a(0), false);
          return;
        }
        if (paramLong2 > paramLong1)
        {
          olh.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.jdField_d_of_type_Int), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, pqf.a(1), false);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
        }
      }
    }
  }
  
  private void a(long paramLong, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, int paramInt)
  {
    if (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString)) {}
    long l1;
    for (String str = paramString;; str = paramCompressInfo.jdField_e_of_type_JavaLangString)
    {
      l1 = new File(str).length();
      this.jdField_a_of_type_Rud.b(paramInt, l1);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "afterCompress picture: w:" + paramCompressInfo.jdField_d_of_type_Int + "  h:" + paramCompressInfo.jdField_e_of_type_Int + " size:" + l1 / 1024L + "kb");
      this.jdField_a_of_type_Rud.d(paramInt, NetConnInfoCenter.getServerTimeMillis());
      if (!a(str, paramInt)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Rud.e(paramInt, NetConnInfoCenter.getServerTimeMillis());
    a(paramLong, l1, paramString, paramCompressInfo, paramBoolean);
  }
  
  private void a(HotPicData paramHotPicData, int paramInt)
  {
    if (paramInt < 9)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, paramHotPicData.originalUrl);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, paramHotPicData.md5);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, Integer.valueOf(paramHotPicData.height));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, Integer.valueOf(paramHotPicData.width));
      this.k += 1;
    }
    for (;;)
    {
      if (this.k == b())
      {
        this.v = true;
        pvj.a().a(this.app.getCurrentUin(), this.jdField_f_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_n_of_type_Int, this.jdField_b_of_type_JavaUtilList, c(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(), this.k, this.jdField_b_of_type_JavaUtilArrayList, this.w, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam, this.jdField_r_of_type_Int);
      }
      return;
      this.u = false;
      l();
    }
  }
  
  private void a(Object paramObject)
  {
    List localList = this.jdField_a_of_type_Rur.a();
    if (b() < 9)
    {
      if ((!(paramObject instanceof String)) || (!localList.contains(paramObject))) {
        break label149;
      }
      paramObject = b((String)paramObject);
    }
    label149:
    for (;;)
    {
      Object localObject1 = paramObject;
      if ((paramObject instanceof HotPicData))
      {
        localObject1 = paramObject;
        if (!localList.contains(paramObject)) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = ((HotPicData)paramObject).clone();
          this.jdField_a_of_type_Rur.a(localList.size() - 1, localObject1);
          b(localObject1);
          if (localList.size() > 9) {
            this.jdField_a_of_type_Rur.d(localList.get(9));
          }
          p();
          return;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          localCloneNotSupportedException.printStackTrace();
          Object localObject2 = paramObject;
          continue;
        }
        a(1, getString(2131717710));
      }
    }
  }
  
  private void a(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.15(this, paramObject, paramInt)).start();
  }
  
  private void a(String paramString, long paramLong, rub paramrub, int paramInt)
  {
    CompressInfo localCompressInfo = paramrub.a();
    boolean bool = paramrub.b();
    if (a(paramrub.a(), paramInt)) {
      return;
    }
    a(paramLong, paramString, localCompressInfo, bool, paramInt);
  }
  
  private void a(List<?> paramList)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramList.next());
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    List localList = this.jdField_a_of_type_Rur.a();
    if (((localList.get(paramInt) instanceof HotPicData)) || (this.jdField_e_of_type_JavaLangString.equals(localList.get(paramInt)))) {
      return true;
    }
    String str = a(localList.get(paramInt));
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        break label98;
      }
      if (str.equals(a(localList.get(i)))) {
        break;
      }
      i += 1;
    }
    label98:
    return true;
  }
  
  private boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (this.u)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, Integer.valueOf(paramOptions.outWidth));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, Integer.valueOf(paramOptions.outHeight));
      return false;
    }
    return true;
  }
  
  private boolean a(FileMsg paramFileMsg)
  {
    return (paramFileMsg == null) || (paramFileMsg.fileType != 24) || (paramFileMsg.commandId != 10);
  }
  
  private boolean a(Object paramObject)
  {
    if (!this.u) {}
    while (paramObject.equals(this.jdField_e_of_type_JavaLangString)) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      l();
      a(1, getString(2131717709));
      i();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    TransFileController localTransFileController = this.app.getTransFileController();
    rue localrue = new rue(this, getMainLooper());
    TransferRequest localTransferRequest = new TransferRequest();
    if (this.u)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "doStartUploadPicposition" + paramInt);
      }
      localrue.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      localTransFileController.addHandle(localrue);
      localTransferRequest.mIsUp = true;
      localTransferRequest.mCommandId = 10;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mUniseq = paramInt;
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mFileType = 24;
      localTransferRequest.mRichTag = "KandianUGCPicUpload";
      localTransFileController.transferAsync(localTransferRequest);
      localrue.a = true;
      this.jdField_c_of_type_JavaUtilList.add(localrue);
      this.jdField_d_of_type_JavaUtilList.add(localTransferRequest);
      return false;
    }
    return true;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Rur != null)
    {
      int j = this.jdField_a_of_type_Rur.a().size();
      int i = j;
      if (this.jdField_a_of_type_Rur.a().get(this.jdField_a_of_type_Rur.a().size() - 1).equals(this.jdField_e_of_type_JavaLangString)) {
        i = j - 1;
      }
      return i;
    }
    return 0;
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      if (azlo.a((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(2));
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(2));
  }
  
  private void b(Object paramObject, int paramInt)
  {
    List localList = this.jdField_a_of_type_Rur.a();
    this.jdField_a_of_type_Rur.a(paramInt, paramObject);
    c(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_Rur.d(localList.get(9));
    }
    p();
  }
  
  private boolean b()
  {
    if (b() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Rur.a().size() - 1)
      {
        if (!(this.jdField_a_of_type_Rur.a().get(i) instanceof HotPicData)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void c(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String))
    {
      if (azlo.a((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
  }
  
  private String e()
  {
    int j = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      String str1;
      if (a().intValue() > 0)
      {
        i = 1;
        localJSONObject.put("topic", i);
        String str2 = d();
        str1 = str2;
        if ("0".equalsIgnoreCase(str2)) {
          str1 = "";
        }
        localJSONObject.put("topicid", str1);
        localJSONObject.put("topic_num", a());
        localJSONObject.put("sticker", rtg.a(c()));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label202;
        }
        i = 1;
        label116:
        localJSONObject.put("location", i);
        if (!c().contains("@")) {
          break label207;
        }
        i = 1;
        label141:
        localJSONObject.put("at", i);
        if (!b()) {
          break label212;
        }
        i = 1;
        label160:
        localJSONObject.put("gif", i);
        if (b() <= 0) {
          break label217;
        }
      }
      label202:
      label207:
      label212:
      label217:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("pic", i);
        str1 = localJSONObject.toString();
        return str1;
        i = 0;
        break;
        i = 0;
        break label116;
        i = 0;
        break label141;
        i = 0;
        break label160;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_n_of_type_Boolean) && (paramInt - this.jdField_c_of_type_Int <= 0)) {
        break label82;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - paramInt));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    while (paramInt - this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      return;
      label82:
      if (this.jdField_n_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  private String f()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "3";
    }
    if (((b() != 0) || (b())) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "1";
    }
    if (((b() != 0) || (b())) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "2";
    }
    return "0";
  }
  
  private void f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rur.a().get(paramInt);
    if ((localObject instanceof HotPicData))
    {
      HotPicData localHotPicData = (HotPicData)localObject;
      if (HotPicPageView.a((HotPicData)localObject) == 0)
      {
        avlz.a(localHotPicData.url).getAbsolutePath();
        g(paramInt);
      }
    }
    for (;;)
    {
      rtg.b();
      return;
      if (((String)this.jdField_a_of_type_Rur.a().get(paramInt)).equals(this.jdField_e_of_type_JavaLangString))
      {
        if (9 - b() > 0)
        {
          n();
          olh.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", pqf.c(), false);
        }
        else
        {
          a(1, getString(2131717710));
        }
      }
      else {
        g(paramInt);
      }
    }
  }
  
  private void g(int paramInt)
  {
    Intent localIntent = new Intent();
    this.l = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Rur.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.jdField_e_of_type_JavaLangString)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(avlz.a(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("back_btn_text", anvx.a(2131712283));
    localIntent.putExtra("from_readinjoy_ugc_deliver", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, NewPhotoPreviewActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("extra.busi_type", 8);
    startActivityForResult(localIntent, 1002);
    this.jdField_o_of_type_Int = 1002;
    overridePendingTransition(2130772292, 2130772294);
  }
  
  private void h(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void i(int paramInt)
  {
    this.jdField_a_of_type_Rur.d(this.jdField_a_of_type_Rur.a().get(paramInt));
    this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    if (b() == 0)
    {
      a(false);
      if (this.jdField_r_of_type_Int == 1)
      {
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    p();
    rtg.l();
  }
  
  private void q()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("readinjoy_draftbox_id", -1L);
      if (this.jdField_a_of_type_Long != -1L) {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.5(this));
      }
    }
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.7(this));
    }
  }
  
  private void t()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new rts(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    o();
  }
  
  private void u()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("peak.myUin", this.app.getAccount());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra.busi_type", 8);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9 - b());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if (9 - b() == 1) {
      localIntent.putExtra("from_readinjoy_ugc", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 25);
      startActivityForResult(localIntent, 1000);
      this.jdField_o_of_type_Int = 1000;
      overridePendingTransition(2130771979, 2130771977);
      return;
      localIntent.putExtra("from_readinjoy_ugc_deliver_preview", true);
    }
  }
  
  private void v()
  {
    oxf.a(this);
    this.jdField_o_of_type_Int = 1001;
    overridePendingTransition(2130771979, 2130771977);
  }
  
  private void w()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.11(this));
  }
  
  private void x()
  {
    l();
    a(1, getString(2131717709));
    i();
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
  }
  
  private void y()
  {
    this.k = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a();
  }
  
  private void z()
  {
    y();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rue)localIterator.next()).a = false;
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      this.app.getTransFileController().stop(localTransferRequest);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_b_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131376182));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367706));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379262));
    boolean bool = rth.d();
    if ((!avmh.a(this.app).b()) || (!bool) || (this.jdField_r_of_type_Int == 1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while ((this.jdField_r_of_type_Int == 1) || (!rth.f()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(false);
  }
  
  public void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if (b() != 0) {
      a(true);
    }
    for (;;)
    {
      if (a().intValue() < this.jdField_q_of_type_Int) {
        rtg.m();
      }
      return;
      if (paramEditable.length() <= 0)
      {
        a(false);
      }
      else if (this.jdField_r_of_type_Int == 1)
      {
        a(true);
        if (b() == 0) {
          this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        } else {
          this.rightViewText.setTextColor(Color.parseColor("#262626"));
        }
      }
      else
      {
        String str = UUID.randomUUID().toString();
        if (rvy.a(paramEditable.toString(), str).trim().length() <= 0) {
          a(false);
        } else {
          a(true);
        }
      }
    }
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    getActivity().getApplicationContext();
    a(true);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    if ((paramHotPicData != null) && (paramHotPicData.url != null))
    {
      a(paramHotPicData);
      a(true);
      rtg.i();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "url=" + paramHotPicData.url);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_q_of_type_Int = a().intValue();
    if (paramInt3 < paramInt2) {
      e(paramCharSequence.length());
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 464	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 621	com/tencent/mobileqq/app/QQAppInterface:getTransFileController	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   7: aload_0
    //   8: invokevirtual 1124	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   11: new 1126	rtt
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 1127	rtt:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity;)V
    //   19: invokevirtual 1131	com/tencent/mobileqq/transfile/TransFileController:cancelSendingPics	(Ljava/lang/String;Lcom/tencent/mobileqq/transfile/TransFileController$OnCancelListener;)V
    //   22: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +13 -> 38
    //   28: ldc_w 350
    //   31: iconst_2
    //   32: ldc_w 1133
    //   35: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: invokespecial 1135	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:f	()Ljava/lang/String;
    //   42: aload_0
    //   43: invokespecial 122	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   46: aload_0
    //   47: invokespecial 1137	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:e	()Ljava/lang/String;
    //   50: invokestatic 1139	rtg:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aconst_null
    //   54: ldc 102
    //   56: ldc_w 1141
    //   59: ldc_w 1141
    //   62: iconst_0
    //   63: iconst_0
    //   64: aload_0
    //   65: invokespecial 1143	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	()I
    //   68: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: aload_0
    //   72: invokespecial 122	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   75: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokevirtual 1144	java/lang/Integer:toString	()Ljava/lang/String;
    //   81: ldc 102
    //   83: aload_0
    //   84: invokevirtual 1146	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()Ljava/lang/String;
    //   87: iconst_0
    //   88: invokestatic 343	olh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   91: aload_0
    //   92: invokespecial 1148	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:a	()Z
    //   95: ifne +5 -> 100
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: invokespecial 122	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   104: ifne +167 -> 271
    //   107: iconst_1
    //   108: istore_1
    //   109: aload_0
    //   110: getfield 109	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   113: ldc_w 1150
    //   116: iload_1
    //   117: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload_0
    //   122: ldc_w 1151
    //   125: invokevirtual 1153	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:d	(I)V
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 493	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   133: aload_0
    //   134: new 66	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 67	java/util/ArrayList:<init>	()V
    //   141: putfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   144: aload_0
    //   145: getfield 125	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   148: aload_0
    //   149: getfield 464	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   152: invokevirtual 903	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 698	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_o_of_type_Boolean	Z
    //   159: aload_0
    //   160: getfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   163: invokestatic 1156	rvy:a	(Landroid/widget/EditText;Ljava/lang/String;ZLjava/util/List;)Z
    //   166: pop
    //   167: aload_0
    //   168: invokestatic 393	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   171: putfield 894	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_Long	J
    //   174: iload_1
    //   175: iconst_1
    //   176: if_icmpne +149 -> 325
    //   179: aload_0
    //   180: getfield 109	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   183: ldc_w 1158
    //   186: iconst_0
    //   187: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: invokestatic 460	pvj:a	()Lpvj;
    //   194: aload_0
    //   195: getfield 464	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 251	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 471	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 473	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_n_of_type_Int	I
    //   213: aload_0
    //   214: getfield 71	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   217: aload_0
    //   218: invokevirtual 474	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:c	()Ljava/lang/String;
    //   221: aconst_null
    //   222: aload_0
    //   223: getfield 88	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   226: invokevirtual 482	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:b	()[I
    //   229: aload_0
    //   230: getfield 88	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   233: invokevirtual 480	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:a	()[I
    //   236: aconst_null
    //   237: aload_0
    //   238: getfield 453	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:k	I
    //   241: aload_0
    //   242: getfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   245: aload_0
    //   246: getfield 486	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:w	Z
    //   249: aload_0
    //   250: getfield 216	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   253: aload_0
    //   254: getfield 162	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam	Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;
    //   257: aload_0
    //   258: getfield 488	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_r_of_type_Int	I
    //   261: invokevirtual 491	pvj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;[Ljava/lang/String;[I[I[Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mobileqq/troop/data/TroopBarPOI;Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;I)V
    //   264: aload_0
    //   265: iconst_0
    //   266: putfield 493	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   269: iconst_1
    //   270: ireturn
    //   271: aload_0
    //   272: getfield 1160	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_m_of_type_Boolean	Z
    //   275: ifne +150 -> 425
    //   278: aload_0
    //   279: invokestatic 1166	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   282: ifne +143 -> 425
    //   285: aload_0
    //   286: invokevirtual 1168	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:k	()V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_2
    //   292: ldc_w 350
    //   295: iconst_2
    //   296: new 366	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 1170
    //   306: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_2
    //   310: invokevirtual 1171	java/lang/Exception:toString	()Ljava/lang/String;
    //   313: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: goto -201 -> 121
    //   325: aload_0
    //   326: getfield 313	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_Rur	Lrur;
    //   329: invokevirtual 503	rur:a	()Ljava/util/List;
    //   332: astore_2
    //   333: iconst_0
    //   334: istore_1
    //   335: aload_2
    //   336: invokeinterface 567 1 0
    //   341: astore_2
    //   342: aload_2
    //   343: invokeinterface 572 1 0
    //   348: ifeq -79 -> 269
    //   351: aload_2
    //   352: invokeinterface 575 1 0
    //   357: astore_3
    //   358: aload_0
    //   359: getfield 493	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   362: ifeq +57 -> 419
    //   365: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +30 -> 398
    //   371: ldc_w 350
    //   374: iconst_2
    //   375: new 366	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 1173
    //   385: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload_1
    //   389: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_0
    //   399: iload_1
    //   400: invokespecial 1175	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(I)Z
    //   403: ifeq +9 -> 412
    //   406: aload_0
    //   407: aload_3
    //   408: iload_1
    //   409: invokespecial 1177	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/Object;I)V
    //   412: iload_1
    //   413: iconst_1
    //   414: iadd
    //   415: istore_1
    //   416: goto -74 -> 342
    //   419: iconst_1
    //   420: ireturn
    //   421: astore_2
    //   422: goto -231 -> 191
    //   425: iconst_2
    //   426: istore_1
    //   427: goto -318 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	ReadInJoyDeliverUGCActivity
    //   108	319	1	i	int
    //   291	19	2	localException1	Exception
    //   332	20	2	localObject1	Object
    //   421	1	2	localException2	Exception
    //   357	51	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   109	121	291	java/lang/Exception
    //   179	191	421	java/lang/Exception
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: iconst_0
    //   4: aload_1
    //   5: bipush 46
    //   7: invokevirtual 1183	java/lang/String:indexOf	(I)I
    //   10: invokevirtual 1186	java/lang/String:substring	(II)Ljava/lang/String;
    //   13: astore 5
    //   15: aload_1
    //   16: aload_1
    //   17: bipush 46
    //   19: invokevirtual 1183	java/lang/String:indexOf	(I)I
    //   22: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   25: astore 4
    //   27: new 366	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   34: aload 5
    //   36: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1188
    //   42: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 5
    //   50: new 366	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   57: aload 5
    //   59: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 5
    //   72: new 259	java/io/File
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 263	java/io/File:exists	()Z
    //   84: ifeq +12 -> 96
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 510	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: new 1190	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 1191	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   104: astore 4
    //   106: new 1193	java/io/FileOutputStream
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 1194	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: sipush 1024
    //   119: newarray byte
    //   121: astore_3
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 1200	java/io/InputStream:read	([B)I
    //   128: istore_2
    //   129: iload_2
    //   130: ifle +53 -> 183
    //   133: aload_1
    //   134: aload_3
    //   135: iconst_0
    //   136: iload_2
    //   137: invokevirtual 1206	java/io/OutputStream:write	([BII)V
    //   140: goto -18 -> 122
    //   143: astore_3
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 104	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   151: astore 4
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 1209	java/io/InputStream:close	()V
    //   161: aload 4
    //   163: astore_3
    //   164: aload_1
    //   165: ifnull -71 -> 94
    //   168: aload_1
    //   169: invokevirtual 1210	java/io/OutputStream:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   180: aload 4
    //   182: areturn
    //   183: aload_0
    //   184: getfield 69	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   187: aload 5
    //   189: invokeinterface 683 2 0
    //   194: pop
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 1209	java/io/InputStream:close	()V
    //   205: aload 5
    //   207: astore_3
    //   208: aload_1
    //   209: ifnull -115 -> 94
    //   212: aload_1
    //   213: invokevirtual 1210	java/io/OutputStream:close	()V
    //   216: aload 5
    //   218: areturn
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   224: aload 5
    //   226: areturn
    //   227: astore_3
    //   228: aload_3
    //   229: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   232: goto -27 -> 205
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   240: goto -79 -> 161
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 1209	java/io/InputStream:close	()V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 1210	java/io/OutputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore 4
    //   271: aload 4
    //   273: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   276: goto -17 -> 259
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 1211	java/io/IOException:printStackTrace	()V
    //   284: goto -17 -> 267
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -41 -> 249
    //   293: astore_3
    //   294: goto -45 -> 249
    //   297: astore 5
    //   299: aload_3
    //   300: astore 4
    //   302: aload 5
    //   304: astore_3
    //   305: goto -56 -> 249
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -164 -> 147
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_1
    //   317: aload 4
    //   319: astore_3
    //   320: goto -173 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	ReadInJoyDeliverUGCActivity
    //   0	323	1	paramString	String
    //   128	9	2	i	int
    //   1	134	3	localObject1	Object
    //   143	1	3	localException	Exception
    //   146	62	3	localObject2	Object
    //   227	2	3	localIOException1	java.io.IOException
    //   235	2	3	localIOException2	java.io.IOException
    //   243	25	3	localObject3	Object
    //   287	1	3	localObject4	Object
    //   293	7	3	localObject5	Object
    //   304	16	3	localObject6	Object
    //   25	230	4	localObject7	Object
    //   269	3	4	localIOException3	java.io.IOException
    //   300	18	4	localObject8	Object
    //   13	212	5	str	String
    //   297	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   116	122	143	java/lang/Exception
    //   122	129	143	java/lang/Exception
    //   133	140	143	java/lang/Exception
    //   183	195	143	java/lang/Exception
    //   168	172	175	java/io/IOException
    //   212	216	219	java/io/IOException
    //   200	205	227	java/io/IOException
    //   157	161	235	java/io/IOException
    //   96	106	243	finally
    //   254	259	269	java/io/IOException
    //   263	267	279	java/io/IOException
    //   106	116	287	finally
    //   116	122	293	finally
    //   122	129	293	finally
    //   133	140	293	finally
    //   183	195	293	finally
    //   147	153	297	finally
    //   96	106	308	java/lang/Exception
    //   106	116	314	java/lang/Exception
  }
  
  public void b()
  {
    boolean bool = false;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = getIntent().getBooleanExtra("support_topic", false);
    this.jdField_i_of_type_Boolean = getIntent().getBooleanExtra("support_linkify", true);
    super.b();
    this.jdField_d_of_type_JavaLangString = "0X800865D";
    this.jdField_a_of_type_Rur = new rur(getApplicationContext(), 3);
    this.jdField_a_of_type_Rur.a(new rtr(this));
    this.jdField_a_of_type_Rur.a(new rtw(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new rtx(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new rty(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_Rur);
    p();
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.jdField_n_of_type_Int = getIntent().getIntExtra("arg_ad_tag", 0);
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.w = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.x = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.y = getIntent().getBooleanExtra("is_from_poly_topic", false);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "initData mTopicId=" + this.jdField_f_of_type_JavaLangString + ", mTopicName=" + this.jdField_g_of_type_JavaLangString + ", mAdTag=" + this.jdField_n_of_type_Int);
    }
    String str1;
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      str1 = "0";
      if (!this.w) {
        break label421;
      }
    }
    label421:
    for (String str2 = "1";; str2 = "2")
    {
      olh.a(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, pqf.c(), false);
      if (bmhv.k(this.app) == 0) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      q();
      return;
      str1 = String.valueOf(this.jdField_f_of_type_JavaLangString);
      break;
    }
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.z)
    {
      rtg.a();
      this.z = true;
    }
    if (rtg.a(paramCharSequence.toString()))
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onTextChanged | insert Emoji");
      rtg.f();
    }
  }
  
  public void c()
  {
    super.c();
    rtg.j();
  }
  
  public void c(int paramInt)
  {
    this.jdField_i_of_type_Int = 1;
    super.c(paramInt);
    rtg.b(String.valueOf(paramInt));
    olh.a(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", pqf.c(), false);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_b_of_type_Bisl.setOnDismissListener(new rtv(this));
    this.jdField_b_of_type_Bisl.c(paramInt);
    if (!this.jdField_b_of_type_Bisl.isShowing()) {
      this.jdField_b_of_type_Bisl.show();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if ((this.jdField_a_of_type_Float - this.jdField_b_of_type_Float > 50.0F) || (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float > 50.0F)) {
        this.jdField_q_of_type_Boolean = false;
      }
      if (!this.jdField_q_of_type_Boolean) {
        break label116;
      }
      f(this.jdField_m_of_type_Int);
      this.jdField_q_of_type_Boolean = false;
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      label116:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.a();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560209);
    bdee.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771979, 2130771977);
    if (isInMultiWindow())
    {
      QQToast.a(this, anvx.a(2131712252), 0).a();
      finish();
      return true;
    }
    this.jdField_r_of_type_Int = getIntent().getIntExtra("ugcPushType", 0);
    if (this.jdField_r_of_type_Int == 1) {
      a(2131717706);
    }
    for (;;)
    {
      a();
      b();
      ptj.a.a(getActivity());
      return true;
      a(2131717715);
    }
  }
  
  public void doOnDestroy()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      rue localrue = (rue)localIterator.next();
      this.app.getTransFileController().removeHandle(localrue);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    pvm.a().b(this.jdField_a_of_type_Pvq);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_o_of_type_Int == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.l = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", 0);
      if ((!TextUtils.isEmpty(str)) && (this.l < this.jdField_b_of_type_JavaUtilList.size()))
      {
        this.jdField_b_of_type_JavaUtilList.remove(this.l);
        this.jdField_a_of_type_Rur.d(this.jdField_a_of_type_Rur.a().get(this.l));
        b(str, this.l);
        this.jdField_e_of_type_JavaUtilList.add(str);
      }
    }
    if (this.jdField_o_of_type_Int == 1001)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        a(paramIntent);
      }
    }
    label245:
    do
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "doOnNewIntent mRequestCode=" + this.jdField_o_of_type_Int + ", path=");
        }
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        this.jdField_o_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        return;
      } while (this.jdField_o_of_type_Int != 1000);
      int i;
      if (9 - b() == 1)
      {
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!(paramIntent instanceof String)) {
          break label316;
        }
        paramIntent = (String)paramIntent;
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
        i = 1;
      }
      for (;;)
      {
        this.s = true;
        olh.a(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", pqf.c(), false);
        break;
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label245;
        if (paramIntent == null) {
          break label340;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        a(paramIntent);
      }
    } while (!QLog.isColorLevel());
    label316:
    label340:
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
    rtg.a("：");
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void e()
  {
    super.e();
    olh.a(null, "", "0X800823E", "0X800823E", 0, 0, "" + a(), "", "", pqf.c(), false);
  }
  
  public void f()
  {
    super.f();
    rtg.c("1");
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      String str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      getIntent().putExtra("arg_result_json", str);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "finish resultJson=" + a(str));
      }
    }
    super.finish();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    rtg.e();
    olh.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", pqf.c(), false);
    super.g();
  }
  
  public void i()
  {
    olh.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
  }
  
  public void j()
  {
    olh.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(2), false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem$ReadInJoyDraftboxContent != null) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.12(this));
    }
    for (;;)
    {
      w();
      finish();
      return;
      s();
    }
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_Bisl != null) && (this.jdField_b_of_type_Bisl.isShowing())) {
      this.jdField_b_of_type_Bisl.dismiss();
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      rtg.h();
      return;
      b(3);
      olh.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", pqf.c(), false);
    }
  }
  
  protected void n()
  {
    if (this.jdField_c_of_type_Bkzi == null)
    {
      this.jdField_c_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_c_of_type_Bkzi.a(2131717705, 5);
      this.jdField_c_of_type_Bkzi.a(2131717707, 5);
      this.jdField_c_of_type_Bkzi.c(2131690697);
      this.jdField_c_of_type_Bkzi.setOnDismissListener(new rtz(this));
      this.jdField_c_of_type_Bkzi.a(new rua(this));
    }
    if (!this.jdField_c_of_type_Bkzi.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_r_of_type_Boolean = false;
      this.jdField_c_of_type_Bkzi.show();
    }
  }
  
  public void o()
  {
    v();
    olh.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", pqf.c(), false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        i(paramInt1);
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      b(0);
      return true;
    }
    if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Rur.a().size() > 1)) && (!this.t))
    {
      h();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      m();
      continue;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
        b(0);
      }
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Rur.a().size() > 1)) && (!this.t))
      {
        h();
      }
      else
      {
        finish();
        continue;
        if ((this.jdField_r_of_type_Int == 1) && (b() == 0)) {
          QQToast.a(this, 1, anvx.a(2131712379), 0).a();
        } else {
          a();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void p()
  {
    List localList = this.jdField_a_of_type_Rur.a();
    if (localList.size() == 0) {
      this.jdField_a_of_type_Rur.c(this.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rur.notifyDataSetChanged();
      return;
      if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_a_of_type_Rur.c(this.jdField_e_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */