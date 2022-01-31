package com.tencent.biz.pubaccount.readinjoy.ugc;

import ajya;
import android.app.Activity;
import android.content.Intent;
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
import aobp;
import apug;
import aqyw;
import aqze;
import arau;
import aupa;
import axle;
import axrn;
import ayvx;
import aywc;
import bbea;
import bcqf;
import bcql;
import bfpc;
import bfpp;
import bhvy;
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
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.os.MqqHandler;
import nol;
import oeg;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import osm;
import qej;
import qek;
import qem;
import qen;
import qeo;
import qep;
import qeq;
import qer;
import qes;
import qeu;
import qev;
import qfh;
import qgo;

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
  osm jdField_a_of_type_Osm = new qem(this);
  private qeu jdField_a_of_type_Qeu = new qeu(this);
  private qfh jdField_a_of_type_Qfh;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private bcqf jdField_b_of_type_Bcqf;
  private ArrayList<SocializeFeedsInfo.BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private bfpc jdField_c_of_type_Bfpc;
  private List<qev> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List<aywc> d;
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
    for (paramHotPicData = arau.a((HotVideoData)paramHotPicData);; paramHotPicData = aqyw.a(paramHotPicData.url))
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
    String str = onh.e();
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
    return bbea.a(apug.d(str));
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("http://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void a(Object paramObject)
  {
    List localList = this.jdField_a_of_type_Qfh.a();
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
          this.jdField_a_of_type_Qfh.a(localList.size() - 1, localObject1);
          b(localObject1);
          if (localList.size() > 9) {
            this.jdField_a_of_type_Qfh.d(localList.get(9));
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
        a(1, getString(2131718426));
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
    List localList = this.jdField_a_of_type_Qfh.a();
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
    if (this.jdField_a_of_type_Qfh != null)
    {
      int j = this.jdField_a_of_type_Qfh.a().size();
      int i = j;
      if (this.jdField_a_of_type_Qfh.a().get(this.jdField_a_of_type_Qfh.a().size() - 1).equals(this.jdField_e_of_type_JavaLangString)) {
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
      if (aupa.a((String)paramObject))
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
    List localList = this.jdField_a_of_type_Qfh.a();
    this.jdField_a_of_type_Qfh.a(paramInt, paramObject);
    c(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_Qfh.d(localList.get(9));
    }
    q();
  }
  
  private boolean b()
  {
    if (b() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Qfh.a().size() - 1)
      {
        if (!(this.jdField_a_of_type_Qfh.a().get(i) instanceof HotPicData)) {
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
      if (aupa.a((String)paramObject))
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
      localObject = this.jdField_a_of_type_Qfh.a().get(paramInt);
      if (!(localObject instanceof HotPicData)) {
        break;
      }
      localHotPicData = (HotPicData)localObject;
    } while (HotPicPageView.a((HotPicData)localObject) != 0);
    aqyw.a(localHotPicData.url).getAbsolutePath();
    e(paramInt);
    return;
    if (((String)this.jdField_a_of_type_Qfh.a().get(paramInt)).equals(this.jdField_e_of_type_JavaLangString))
    {
      if (9 - b() > 0)
      {
        o();
        nol.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", onh.e(), false);
        return;
      }
      a(1, getString(2131718426));
      return;
    }
    e(paramInt);
  }
  
  private void e(int paramInt)
  {
    Intent localIntent = new Intent();
    this.l = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Qfh.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.jdField_e_of_type_JavaLangString)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(aqyw.a(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("back_btn_text", ajya.a(2131712832));
    localIntent.putExtra("from_readinjoy_ugc_deliver", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, NewPhotoPreviewActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("extra.busi_type", 8);
    startActivityForResult(localIntent, 1002);
    this.jdField_o_of_type_Int = 1002;
    overridePendingTransition(2130772271, 2130772273);
  }
  
  private void f(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    axrn localaxrn = axrn.a(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_Qfh.d(this.jdField_a_of_type_Qfh.a().get(paramInt));
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
      requestPermissions(new qek(this), 2000, new String[] { "android.permission.CAMERA" });
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
    oeg.a(this);
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
      ((qev)localIterator.next()).a = false;
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aywc localaywc = (aywc)localIterator.next();
      this.app.a().a(localaywc);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_b_of_type_Bcqf = new bcqf(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131374787));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367053));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377595));
    int i = bhvy.o(this.app);
    if ((!aqze.a(this.app).b()) || (i == 1) || (this.jdField_q_of_type_Int == 1)) {
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
    if (qgo.a(paramEditable.toString(), str).trim().length() <= 0)
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(aobp paramaobp)
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
    //   4: invokevirtual 714	com/tencent/mobileqq/app/QQAppInterface:a	()Layvx;
    //   7: aload_0
    //   8: invokevirtual 832	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   11: new 834	qel
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 835	qel:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity;)V
    //   19: invokevirtual 838	ayvx:a	(Ljava/lang/String;Laywa;)V
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
    //   73: invokestatic 462	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
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
    //   148: invokestatic 857	qgo:a	(Landroid/widget/EditText;Ljava/lang/String;ZLjava/util/List;)Z
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
    //   176: invokestatic 864	osg:a	()Losg;
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
    //   246: invokevirtual 873	osg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;[Ljava/lang/String;[I[I[Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mobileqq/troop/data/TroopBarPOI;Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;I)V
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 434	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   254: iconst_1
    //   255: ireturn
    //   256: aload_0
    //   257: getfield 875	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_m_of_type_Boolean	Z
    //   260: ifne +150 -> 410
    //   263: aload_0
    //   264: invokestatic 880	bbfj:h	(Landroid/content/Context;)Z
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
    //   311: getfield 297	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_Qfh	Lqfh;
    //   314: invokevirtual 322	qfh:a	()Ljava/util/List;
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
    //   22: aload_1
    //   23: invokevirtual 797	java/lang/String:length	()I
    //   26: invokevirtual 904	java/lang/String:substring	(II)Ljava/lang/String;
    //   29: astore 4
    //   31: new 818	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   38: aload 5
    //   40: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 906
    //   46: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 5
    //   54: new 818	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 819	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 826	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 5
    //   76: new 254	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 258	java/io/File:exists	()Z
    //   88: ifeq +12 -> 100
    //   91: aload_0
    //   92: aload 5
    //   94: invokevirtual 329	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: areturn
    //   100: new 908	java/io/FileInputStream
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 909	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   108: astore 4
    //   110: new 911	java/io/FileOutputStream
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 912	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   119: astore_1
    //   120: sipush 1024
    //   123: newarray byte
    //   125: astore_3
    //   126: aload 4
    //   128: aload_3
    //   129: invokevirtual 918	java/io/InputStream:read	([B)I
    //   132: istore_2
    //   133: iload_2
    //   134: ifle +53 -> 187
    //   137: aload_1
    //   138: aload_3
    //   139: iconst_0
    //   140: iload_2
    //   141: invokevirtual 924	java/io/OutputStream:write	([BII)V
    //   144: goto -18 -> 126
    //   147: astore_3
    //   148: aload 4
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 103	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   155: astore 4
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 927	java/io/InputStream:close	()V
    //   165: aload 4
    //   167: astore_3
    //   168: aload_1
    //   169: ifnull -71 -> 98
    //   172: aload_1
    //   173: invokevirtual 928	java/io/OutputStream:close	()V
    //   176: aload 4
    //   178: areturn
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   184: aload 4
    //   186: areturn
    //   187: aload_0
    //   188: getfield 68	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   191: aload 5
    //   193: invokeinterface 420 2 0
    //   198: pop
    //   199: aload 4
    //   201: ifnull +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 927	java/io/InputStream:close	()V
    //   209: aload 5
    //   211: astore_3
    //   212: aload_1
    //   213: ifnull -115 -> 98
    //   216: aload_1
    //   217: invokevirtual 928	java/io/OutputStream:close	()V
    //   220: aload 5
    //   222: areturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   228: aload 5
    //   230: areturn
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   236: goto -27 -> 209
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   244: goto -79 -> 165
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_1
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 927	java/io/InputStream:close	()V
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 928	java/io/OutputStream:close	()V
    //   271: aload_3
    //   272: athrow
    //   273: astore 4
    //   275: aload 4
    //   277: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   280: goto -17 -> 263
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 929	java/io/IOException:printStackTrace	()V
    //   288: goto -17 -> 271
    //   291: astore_3
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -41 -> 253
    //   297: astore_3
    //   298: goto -45 -> 253
    //   301: astore 5
    //   303: aload_3
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: goto -56 -> 253
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_1
    //   315: goto -164 -> 151
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_1
    //   321: aload 4
    //   323: astore_3
    //   324: goto -173 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	ReadInJoyDeliverUGCActivity
    //   0	327	1	paramString	String
    //   132	9	2	i	int
    //   1	138	3	localObject1	Object
    //   147	1	3	localException	java.lang.Exception
    //   150	62	3	localObject2	Object
    //   231	2	3	localIOException1	java.io.IOException
    //   239	2	3	localIOException2	java.io.IOException
    //   247	25	3	localObject3	Object
    //   291	1	3	localObject4	Object
    //   297	7	3	localObject5	Object
    //   308	16	3	localObject6	Object
    //   29	230	4	localObject7	Object
    //   273	3	4	localIOException3	java.io.IOException
    //   304	18	4	localObject8	Object
    //   13	216	5	str	String
    //   301	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   120	126	147	java/lang/Exception
    //   126	133	147	java/lang/Exception
    //   137	144	147	java/lang/Exception
    //   187	199	147	java/lang/Exception
    //   172	176	179	java/io/IOException
    //   216	220	223	java/io/IOException
    //   204	209	231	java/io/IOException
    //   161	165	239	java/io/IOException
    //   100	110	247	finally
    //   258	263	273	java/io/IOException
    //   267	271	283	java/io/IOException
    //   110	120	291	finally
    //   120	126	297	finally
    //   126	133	297	finally
    //   137	144	297	finally
    //   187	199	297	finally
    //   151	157	301	finally
    //   100	110	312	java/lang/Exception
    //   110	120	318	java/lang/Exception
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
    this.jdField_a_of_type_Qfh = new qfh(getApplicationContext(), 3);
    this.jdField_a_of_type_Qfh.a(new qej(this));
    this.jdField_a_of_type_Qfh.a(new qeo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new qep(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new qeq(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_Qfh);
    q();
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.jdField_n_of_type_Int = getIntent().getIntExtra("arg_ad_tag", 0);
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.w = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.x = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.y = getIntent().getBooleanExtra("is_from_poly_topic", false);
    osj.a().a(this.jdField_a_of_type_Osm);
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
      nol.a(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, onh.e(), false);
      if (bhvy.p(this.app) == 0) {
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
    this.jdField_b_of_type_Bcqf = new bcqf(this, super.getTitleBarHeight());
    this.jdField_b_of_type_Bcqf.setOnDismissListener(new qen(this));
    this.jdField_b_of_type_Bcqf.c(paramInt);
    if (!this.jdField_b_of_type_Bcqf.isShowing()) {
      this.jdField_b_of_type_Bcqf.show();
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
        break label94;
      }
      d(this.jdField_m_of_type_Int);
      this.jdField_q_of_type_Boolean = false;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label94:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.a();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559902);
    axle.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771979, 2130771977);
    if (isInMultiWindow())
    {
      bcql.a(this, ajya.a(2131712801), 0).a();
      finish();
      return true;
    }
    this.jdField_q_of_type_Int = getIntent().getIntExtra("ugcPushType", 0);
    if (this.jdField_q_of_type_Int == 1) {
      a(2131718422);
    }
    for (;;)
    {
      a();
      b();
      return true;
      a(2131718432);
    }
  }
  
  public void doOnDestroy()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      qev localqev = (qev)localIterator.next();
      this.app.a().b(localqev);
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    osj.a().b(this.jdField_a_of_type_Osm);
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
        this.jdField_a_of_type_Qfh.d(this.jdField_a_of_type_Qfh.a().get(this.l));
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
        nol.a(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", onh.e(), false);
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
    nol.a(null, "", "0X800823E", "0X800823E", 0, 0, "" + a(), "", "", onh.e(), false);
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
    nol.a(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", onh.e(), false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    nol.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", onh.e(), false);
    super.h();
  }
  
  public void j()
  {
    nol.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
  }
  
  public void k()
  {
    nol.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(2), false);
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
    if ((this.jdField_b_of_type_Bcqf != null) && (this.jdField_b_of_type_Bcqf.isShowing())) {
      this.jdField_b_of_type_Bcqf.dismiss();
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
    nol.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", onh.e(), false);
  }
  
  protected void o()
  {
    if (this.jdField_c_of_type_Bfpc == null)
    {
      this.jdField_c_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
      this.jdField_c_of_type_Bfpc.a(2131718421, 5);
      this.jdField_c_of_type_Bfpc.a(2131718423, 5);
      this.jdField_c_of_type_Bfpc.c(2131690596);
      this.jdField_c_of_type_Bfpc.setOnDismissListener(new qer(this));
      this.jdField_c_of_type_Bfpc.a(new qes(this));
    }
    if (!this.jdField_c_of_type_Bfpc.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.r = false;
      this.jdField_c_of_type_Bfpc.show();
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
    if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Qfh.a().size() > 1)) && (!this.t))
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
      return;
    case 2131367053: 
      n();
      return;
    case 2131368431: 
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
        b(0);
      }
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Qfh.a().size() > 1)) && (!this.t))
      {
        i();
        return;
      }
      finish();
      return;
    }
    if ((this.jdField_q_of_type_Int == 1) && (b() == 0))
    {
      bcql.a(this, 1, ajya.a(2131712928), 0).a();
      return;
    }
    a();
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void p()
  {
    w();
    nol.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", onh.e(), false);
  }
  
  public void q()
  {
    List localList = this.jdField_a_of_type_Qfh.a();
    if (localList.size() == 0) {
      this.jdField_a_of_type_Qfh.c(this.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qfh.notifyDataSetChanged();
      return;
      if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_a_of_type_Qfh.c(this.jdField_e_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */