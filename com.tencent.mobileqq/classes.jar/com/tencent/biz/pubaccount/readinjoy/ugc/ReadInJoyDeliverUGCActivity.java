package com.tencent.biz.pubaccount.readinjoy.ugc;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
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
import anni;
import asbq;
import atvo;
import avbc;
import avbk;
import avda;
import ayzh;
import bcls;
import bctj;
import bdzi;
import bdzn;
import bgmj;
import biau;
import bkho;
import bkif;
import bmqa;
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
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
import oat;
import org.json.JSONException;
import org.json.JSONObject;
import ovj;
import pha;
import pmk;
import pmn;
import rjm;
import rjn;
import rjp;
import rjq;
import rjr;
import rjs;
import rjt;
import rju;
import rjv;
import rjx;
import rjy;
import rkk;
import rlr;

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
  pmn jdField_a_of_type_Pmn = new rjp(this);
  private rjx jdField_a_of_type_Rjx = new rjx(this);
  private rkk jdField_a_of_type_Rkk;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private biau jdField_b_of_type_Biau;
  private ArrayList<SocializeFeedsInfo.BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private bkho jdField_c_of_type_Bkho;
  private List<rjy> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List<bdzn> d;
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
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  
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
    for (paramHotPicData = avda.a((HotVideoData)paramHotPicData);; paramHotPicData = avbc.a(paramHotPicData.url))
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
    String str = pha.g();
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
    return bgmj.a(atvo.e(str));
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("https://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void a(Object paramObject)
  {
    List localList = this.jdField_a_of_type_Rkk.a();
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
          this.jdField_a_of_type_Rkk.a(localList.size() - 1, localObject1);
          b(localObject1);
          if (localList.size() > 9) {
            this.jdField_a_of_type_Rkk.d(localList.get(9));
          }
          q();
          return;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          localCloneNotSupportedException.printStackTrace();
          Object localObject2 = paramObject;
          continue;
        }
        a(1, getString(2131716991));
      }
    }
  }
  
  private void a(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.15(this, paramObject, paramInt)).start();
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
    List localList = this.jdField_a_of_type_Rkk.a();
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
  
  private int b()
  {
    if (this.jdField_a_of_type_Rkk != null)
    {
      int j = this.jdField_a_of_type_Rkk.a().size();
      int i = j;
      if (this.jdField_a_of_type_Rkk.a().get(this.jdField_a_of_type_Rkk.a().size() - 1).equals(this.jdField_e_of_type_JavaLangString)) {
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
      if (ayzh.a((String)paramObject))
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
    List localList = this.jdField_a_of_type_Rkk.a();
    this.jdField_a_of_type_Rkk.a(paramInt, paramObject);
    c(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_Rkk.d(localList.get(9));
    }
    q();
  }
  
  private boolean b()
  {
    if (b() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Rkk.a().size() - 1)
      {
        if (!(this.jdField_a_of_type_Rkk.a().get(i) instanceof HotPicData)) {
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
      if (ayzh.a((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
  }
  
  private void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {}
    Object localObject;
    HotPicData localHotPicData;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Rkk.a().get(paramInt);
      if (!(localObject instanceof HotPicData)) {
        break;
      }
      localHotPicData = (HotPicData)localObject;
    } while (HotPicPageView.a((HotPicData)localObject) != 0);
    avbc.a(localHotPicData.url).getAbsolutePath();
    e(paramInt);
    return;
    if (((String)this.jdField_a_of_type_Rkk.a().get(paramInt)).equals(this.jdField_e_of_type_JavaLangString))
    {
      if (9 - b() > 0)
      {
        o();
        oat.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", pha.g(), false);
        return;
      }
      a(1, getString(2131716991));
      return;
    }
    e(paramInt);
  }
  
  private void e(int paramInt)
  {
    Intent localIntent = new Intent();
    this.l = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Rkk.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.jdField_e_of_type_JavaLangString)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(avbc.a(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("back_btn_text", anni.a(2131711595));
    localIntent.putExtra("from_readinjoy_ugc_deliver", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, NewPhotoPreviewActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("extra.busi_type", 8);
    startActivityForResult(localIntent, 1002);
    this.jdField_o_of_type_Int = 1002;
    overridePendingTransition(2130772295, 2130772297);
  }
  
  private void f(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    bctj localbctj = bctj.a(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localbctj.a(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_Rkk.d(this.jdField_a_of_type_Rkk.a().get(paramInt));
    this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    if (b() == 0)
    {
      a(false);
      if (this.jdField_q_of_type_Int == 1)
      {
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    q();
  }
  
  private void r()
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
  
  private void s()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.7(this));
    }
  }
  
  private void u()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new rjn(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    p();
  }
  
  private void v()
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
  
  private void w()
  {
    ovj.a(this);
    this.jdField_o_of_type_Int = 1001;
    overridePendingTransition(2130771979, 2130771977);
  }
  
  private void x()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.11(this));
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
      ((rjy)localIterator.next()).a = false;
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bdzn localbdzn = (bdzn)localIterator.next();
      this.app.a().a(localbdzn);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_b_of_type_Biau = new biau(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131376031));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367482));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379035));
    int i = bmqa.o(this.app);
    if ((!avbk.a(this.app).b()) || (i == 1) || (this.jdField_q_of_type_Int == 1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (this.jdField_q_of_type_Int == 1)
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
    if (b() != 0)
    {
      a(true);
      return;
    }
    if (paramEditable.length() <= 0)
    {
      a(false);
      return;
    }
    if (this.jdField_q_of_type_Int == 1)
    {
      a(true);
      if (b() == 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      this.rightViewText.setTextColor(Color.parseColor("#262626"));
      return;
    }
    String str = UUID.randomUUID().toString();
    if (rlr.a(paramEditable.toString(), str).trim().length() <= 0)
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(asbq paramasbq)
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
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "url=" + paramHotPicData.url);
      }
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 570	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 714	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   7: aload_0
    //   8: invokevirtual 832	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   11: new 834	rjo
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 835	rjo:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity;)V
    //   19: invokevirtual 838	bdzi:a	(Ljava/lang/String;Lbdzl;)V
    //   22: invokestatic 814	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +13 -> 38
    //   28: ldc_w 816
    //   31: iconst_2
    //   32: ldc_w 840
    //   35: invokestatic 829	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: ldc 101
    //   41: ldc_w 842
    //   44: ldc_w 842
    //   47: iconst_0
    //   48: iconst_0
    //   49: aload_0
    //   50: invokespecial 844	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	()I
    //   53: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   56: aload_0
    //   57: invokespecial 121	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   60: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: invokevirtual 845	java/lang/Integer:toString	()Ljava/lang/String;
    //   66: ldc 101
    //   68: aload_0
    //   69: invokevirtual 847	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()Ljava/lang/String;
    //   72: iconst_0
    //   73: invokestatic 462	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   76: aload_0
    //   77: invokespecial 849	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:a	()Z
    //   80: ifne +5 -> 85
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_0
    //   86: invokespecial 121	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   89: ifne +167 -> 256
    //   92: iconst_1
    //   93: istore_1
    //   94: aload_0
    //   95: getfield 108	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   98: ldc_w 851
    //   101: iload_1
    //   102: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_0
    //   107: ldc_w 852
    //   110: invokevirtual 854	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:c	(I)V
    //   113: aload_0
    //   114: iconst_1
    //   115: putfield 434	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   118: aload_0
    //   119: new 65	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 66	java/util/ArrayList:<init>	()V
    //   126: putfield 286	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   129: aload_0
    //   130: getfield 124	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   133: aload_0
    //   134: getfield 570	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: invokevirtual 575	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 424	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_o_of_type_Boolean	Z
    //   144: aload_0
    //   145: getfield 286	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   148: invokestatic 857	rlr:a	(Landroid/widget/EditText;Ljava/lang/String;ZLjava/util/List;)Z
    //   151: pop
    //   152: aload_0
    //   153: invokestatic 559	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   156: putfield 561	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_Long	J
    //   159: iload_1
    //   160: iconst_1
    //   161: if_icmpne +149 -> 310
    //   164: aload_0
    //   165: getfield 108	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   168: ldc_w 859
    //   171: iconst_0
    //   172: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: invokestatic 864	pmh:a	()Lpmh;
    //   179: aload_0
    //   180: getfield 570	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 865	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 246	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   190: aload_0
    //   191: getfield 402	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 398	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_n_of_type_Int	I
    //   198: aload_0
    //   199: getfield 70	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   202: aload_0
    //   203: invokevirtual 440	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:c	()Ljava/lang/String;
    //   206: aconst_null
    //   207: aload_0
    //   208: getfield 87	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   211: invokevirtual 868	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:b	()[I
    //   214: aload_0
    //   215: getfield 87	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   218: invokevirtual 870	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:a	()[I
    //   221: aconst_null
    //   222: aload_0
    //   223: getfield 436	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:k	I
    //   226: aload_0
    //   227: getfield 286	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   230: aload_0
    //   231: getfield 466	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:w	Z
    //   234: aload_0
    //   235: getfield 215	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   238: aload_0
    //   239: getfield 161	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam	Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;
    //   242: aload_0
    //   243: getfield 584	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_q_of_type_Int	I
    //   246: invokevirtual 873	pmh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;[Ljava/lang/String;[I[I[Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mobileqq/troop/data/TroopBarPOI;Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;I)V
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 434	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   254: iconst_1
    //   255: ireturn
    //   256: aload_0
    //   257: getfield 875	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_m_of_type_Boolean	Z
    //   260: ifne +150 -> 410
    //   263: aload_0
    //   264: invokestatic 880	bgnt:h	(Landroid/content/Context;)Z
    //   267: ifne +143 -> 410
    //   270: aload_0
    //   271: invokevirtual 882	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:l	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_2
    //   277: ldc_w 816
    //   280: iconst_2
    //   281: new 818	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 884
    //   291: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_2
    //   295: invokevirtual 885	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 829	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto -201 -> 106
    //   310: aload_0
    //   311: getfield 297	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_Rkk	Lrkk;
    //   314: invokevirtual 322	rkk:a	()Ljava/util/List;
    //   317: astore_2
    //   318: iconst_0
    //   319: istore_1
    //   320: aload_2
    //   321: invokeinterface 372 1 0
    //   326: astore_2
    //   327: aload_2
    //   328: invokeinterface 377 1 0
    //   333: ifeq -79 -> 254
    //   336: aload_2
    //   337: invokeinterface 380 1 0
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 434	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   347: ifeq +57 -> 404
    //   350: invokestatic 814	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +30 -> 383
    //   356: ldc_w 816
    //   359: iconst_2
    //   360: new 818	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 887
    //   370: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload_1
    //   374: invokevirtual 890	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 829	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_0
    //   384: iload_1
    //   385: invokespecial 892	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(I)Z
    //   388: ifeq +9 -> 397
    //   391: aload_0
    //   392: aload_3
    //   393: iload_1
    //   394: invokespecial 894	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/Object;I)V
    //   397: iload_1
    //   398: iconst_1
    //   399: iadd
    //   400: istore_1
    //   401: goto -74 -> 327
    //   404: iconst_1
    //   405: ireturn
    //   406: astore_2
    //   407: goto -231 -> 176
    //   410: iconst_2
    //   411: istore_1
    //   412: goto -318 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	ReadInJoyDeliverUGCActivity
    //   93	319	1	i	int
    //   276	19	2	localException1	java.lang.Exception
    //   317	20	2	localObject1	Object
    //   406	1	2	localException2	java.lang.Exception
    //   342	51	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   94	106	276	java/lang/Exception
    //   164	176	406	java/lang/Exception
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
    //   7: invokevirtual 900	java/lang/String:indexOf	(I)I
    //   10: invokevirtual 904	java/lang/String:substring	(II)Ljava/lang/String;
    //   13: astore 5
    //   15: aload_1
    //   16: aload_1
    //   17: bipush 46
    //   19: invokevirtual 900	java/lang/String:indexOf	(I)I
    //   22: invokevirtual 906	java/lang/String:substring	(I)Ljava/lang/String;
    //   25: astore 4
    //   27: new 818	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   34: aload 5
    //   36: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 908
    //   42: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 5
    //   50: new 818	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   57: aload 5
    //   59: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 5
    //   72: new 254	java/io/File
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 258	java/io/File:exists	()Z
    //   84: ifeq +12 -> 96
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 329	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: new 910	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 911	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   104: astore 4
    //   106: new 913	java/io/FileOutputStream
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 914	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: sipush 1024
    //   119: newarray byte
    //   121: astore_3
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 920	java/io/InputStream:read	([B)I
    //   128: istore_2
    //   129: iload_2
    //   130: ifle +53 -> 183
    //   133: aload_1
    //   134: aload_3
    //   135: iconst_0
    //   136: iload_2
    //   137: invokevirtual 926	java/io/OutputStream:write	([BII)V
    //   140: goto -18 -> 122
    //   143: astore_3
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 103	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   151: astore 4
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 929	java/io/InputStream:close	()V
    //   161: aload 4
    //   163: astore_3
    //   164: aload_1
    //   165: ifnull -71 -> 94
    //   168: aload_1
    //   169: invokevirtual 930	java/io/OutputStream:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   180: aload 4
    //   182: areturn
    //   183: aload_0
    //   184: getfield 68	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   187: aload 5
    //   189: invokeinterface 420 2 0
    //   194: pop
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 929	java/io/InputStream:close	()V
    //   205: aload 5
    //   207: astore_3
    //   208: aload_1
    //   209: ifnull -115 -> 94
    //   212: aload_1
    //   213: invokevirtual 930	java/io/OutputStream:close	()V
    //   216: aload 5
    //   218: areturn
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   224: aload 5
    //   226: areturn
    //   227: astore_3
    //   228: aload_3
    //   229: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   232: goto -27 -> 205
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   240: goto -79 -> 161
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 929	java/io/InputStream:close	()V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 930	java/io/OutputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore 4
    //   271: aload 4
    //   273: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   276: goto -17 -> 259
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 931	java/io/IOException:printStackTrace	()V
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
    //   143	1	3	localException	java.lang.Exception
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
    this.jdField_a_of_type_Rkk = new rkk(getApplicationContext(), 3);
    this.jdField_a_of_type_Rkk.a(new rjm(this));
    this.jdField_a_of_type_Rkk.a(new rjr(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new rjs(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new rjt(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_Rkk);
    q();
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.jdField_n_of_type_Int = getIntent().getIntExtra("arg_ad_tag", 0);
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.w = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.x = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.y = getIntent().getBooleanExtra("is_from_poly_topic", false);
    pmk.a().a(this.jdField_a_of_type_Pmn);
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
      oat.a(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, pha.g(), false);
      if (bmqa.p(this.app) == 0) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      r();
      return;
      str1 = String.valueOf(this.jdField_f_of_type_JavaLangString);
      break;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Biau = new biau(this, super.getTitleBarHeight());
    this.jdField_b_of_type_Biau.setOnDismissListener(new rjq(this));
    this.jdField_b_of_type_Biau.c(paramInt);
    if (!this.jdField_b_of_type_Biau.isShowing()) {
      this.jdField_b_of_type_Biau.show();
    }
  }
  
  public void d()
  {
    super.d();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
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
        break label105;
      }
      d(this.jdField_m_of_type_Int);
      this.jdField_q_of_type_Boolean = false;
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
      return bool;
      label105:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.a();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560143);
    bcls.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771979, 2130771977);
    if (isInMultiWindow())
    {
      QQToast.a(this, anni.a(2131711564), 0).a();
      finish();
      return true;
    }
    this.jdField_q_of_type_Int = getIntent().getIntExtra("ugcPushType", 0);
    if (this.jdField_q_of_type_Int == 1) {
      a(2131716987);
    }
    for (;;)
    {
      a();
      b();
      return true;
      a(2131716996);
    }
  }
  
  public void doOnDestroy()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      rjy localrjy = (rjy)localIterator.next();
      this.app.a().b(localrjy);
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    pmk.a().b(this.jdField_a_of_type_Pmn);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_o_of_type_Int == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaUtilList.remove(this.l);
        this.jdField_a_of_type_Rkk.d(this.jdField_a_of_type_Rkk.a().get(this.l));
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
    label217:
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
          break label288;
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
        oat.a(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", pha.g(), false);
        break;
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label217;
        if (paramIntent == null) {
          break label312;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        a(paramIntent);
      }
    } while (!QLog.isColorLevel());
    label288:
    label312:
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void e()
  {
    super.e();
    oat.a(null, "", "0X800823E", "0X800823E", 0, 0, "" + a(), "", "", pha.g(), false);
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
    this.jdField_i_of_type_Int = 1;
    super.g();
    oat.a(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", pha.g(), false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    oat.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", pha.g(), false);
    super.h();
  }
  
  public void j()
  {
    oat.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
  }
  
  public void k()
  {
    oat.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(2), false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem$ReadInJoyDraftboxContent != null) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.12(this));
    }
    for (;;)
    {
      x();
      finish();
      return;
      t();
    }
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_Biau != null) && (this.jdField_b_of_type_Biau.isShowing())) {
      this.jdField_b_of_type_Biau.dismiss();
    }
  }
  
  protected void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      b(1);
      return;
    }
    b(3);
    oat.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", pha.g(), false);
  }
  
  protected void o()
  {
    if (this.jdField_c_of_type_Bkho == null)
    {
      this.jdField_c_of_type_Bkho = ((bkho)bkif.a(this, null));
      this.jdField_c_of_type_Bkho.a(2131716986, 5);
      this.jdField_c_of_type_Bkho.a(2131716988, 5);
      this.jdField_c_of_type_Bkho.c(2131690582);
      this.jdField_c_of_type_Bkho.setOnDismissListener(new rju(this));
      this.jdField_c_of_type_Bkho.a(new rjv(this));
    }
    if (!this.jdField_c_of_type_Bkho.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.r = false;
      this.jdField_c_of_type_Bkho.show();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        g(paramInt1);
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
    if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Rkk.a().size() > 1)) && (!this.t))
    {
      i();
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
      n();
      continue;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
        b(0);
      }
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Rkk.a().size() > 1)) && (!this.t))
      {
        i();
      }
      else
      {
        finish();
        continue;
        if ((this.jdField_q_of_type_Int == 1) && (b() == 0)) {
          QQToast.a(this, 1, anni.a(2131711691), 0).a();
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
    w();
    oat.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", pha.g(), false);
  }
  
  public void q()
  {
    List localList = this.jdField_a_of_type_Rkk.a();
    if (localList.size() == 0) {
      this.jdField_a_of_type_Rkk.c(this.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rkk.notifyDataSetChanged();
      return;
      if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_a_of_type_Rkk.c(this.jdField_e_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */