package com.tencent.biz.pubaccount.readinjoy.comment;

import ahbf;
import ahbn;
import ahbw;
import alud;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apuc;
import asub;
import aswh;
import azah;
import bayf;
import bayj;
import bdfr;
import bdin;
import bety;
import bhsl;
import bicy;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nrt;
import ntd;
import oij;
import okl;
import okm;
import okn;
import oko;
import okp;
import okq;
import okr;
import oks;
import okt;
import oku;
import olt;
import opj;
import oqu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import osk;
import qmc;
import qmr;
import qqu;
import rqj;
import rvv;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements ahbn, Handler.Callback, View.OnClickListener
{
  protected int a;
  private ahbw jdField_a_of_type_Ahbw;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new okp(this);
  protected TextWatcher a;
  public ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  public FrameLayout a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private apuc jdField_a_of_type_Apuc = new okr(this);
  private aswh jdField_a_of_type_Aswh = new oks(this);
  bayj jdField_a_of_type_Bayj = new oko(this);
  protected bety a;
  private bicy jdField_a_of_type_Bicy = new okq(this);
  public BiuEditText a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public EmoticonMainPanel a;
  public HotPicData a;
  public PublicAccountHotPicPanel a;
  public XPanelContainer a;
  private String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  private String b;
  public boolean b;
  public int c;
  protected ImageView c;
  protected RelativeLayout c;
  public TextView c;
  private String c;
  protected boolean c;
  protected int d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  private String d;
  public boolean d;
  protected int e;
  protected ImageView e;
  protected RelativeLayout e;
  private String e;
  public boolean e;
  public int f;
  public ImageView f;
  private boolean f;
  public int g;
  protected ImageView g;
  private boolean g;
  private int jdField_h_of_type_Int = -1;
  protected ImageView h;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 1;
  protected ImageView i;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = 1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  private boolean o;
  private boolean p = true;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = oqu.jdField_b_of_type_Int;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new okl(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new okm(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private ahbf a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null)) {}
    Object localObject;
    do
    {
      Bundle localBundle;
      do
      {
        return null;
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
        localBundle = getArguments();
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (bkbq.m((AppRuntime)localObject) != 0));
      localObject = ahbf.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ahbf)localObject).e()));
    return localObject;
  }
  
  private Intent a()
  {
    int i1 = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label975:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_c_of_type_Boolean);
        localJSONObject1.put("comment", new String(bdfr.encode(a().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        oku localoku;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_Ahbw != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_l_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.jdField_m_of_type_Boolean);
            localJSONObject1.put("commentId", this.jdField_b_of_type_JavaLangString);
            localJSONObject1.put("commentUin", this.jdField_c_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = a();
            if (localObject1 != null) {
              localJSONObject1.put("biu_info", localObject1);
            }
          }
          if ((!this.jdField_g_of_type_Boolean) || (TextUtils.isEmpty(a()))) {
            continue;
          }
          localObject3 = new ArrayList();
          a((ArrayList)localObject3);
          if (((ArrayList)localObject3).size() <= 0) {
            continue;
          }
          localObject4 = new JSONArray();
          i1 = ((ArrayList)localObject3).size() - 1;
          if (i1 < 0) {
            continue;
          }
          localoku = (oku)((ArrayList)localObject3).get(i1);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localoku.jdField_a_of_type_JavaLangString));
          localObject1 = "";
          if (TextUtils.isEmpty(localoku.jdField_a_of_type_JavaLangCharSequence)) {
            localoku.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          }
          if (localoku.jdField_a_of_type_JavaLangCharSequence != null) {
            localObject1 = localoku.jdField_a_of_type_JavaLangCharSequence.toString();
          }
          localJSONObject2.put("nick", new String(bdfr.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localoku.b != null) {
            localObject1 = localoku.b.toString();
          }
          localJSONObject2.put("comment", new String(bdfr.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localoku.jdField_a_of_type_Int);
          ((JSONArray)localObject4).put(localJSONObject2);
          i1 -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label975;
          }
          localJSONObject1.put("biuAfterComment", i1);
          continue;
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        catch (Exception localException)
        {
          localJSONObject2.put("uin", 0L);
          continue;
        }
        localJSONObject1.put("commentAtLevel", localObject4);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
        {
          localObject2 = new JSONArray();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("picType", 3);
          ((JSONObject)localObject3).put("url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl);
          ((JSONObject)localObject3).put("md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalMD5);
          ((JSONObject)localObject3).put("width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalWidth);
          ((JSONObject)localObject3).put("height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalHeight);
          ((JSONObject)localObject3).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
          ((JSONObject)localObject3).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5);
          ((JSONObject)localObject3).put("thumbnail_width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width);
          ((JSONObject)localObject3).put("thumbnail_height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height);
          ((JSONArray)localObject2).put(localObject3);
          localJSONObject1.put("picInfoList", localObject2);
        }
        if ((this.jdField_a_of_type_Ahbw != null) && (this.jdField_a_of_type_Ahbw.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_Ahbw.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_Ahbw.f);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_Ahbw.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_Ahbw.f);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_Ahbw.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(ors.a()), null);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        localIntent.putExtra("comment_articleid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("comment_gallery_channel", this.jdField_i_of_type_Boolean);
        localIntent.putExtra("comment_cmd", this.jdField_k_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          i1 = 2;
          localIntent.putExtra("click_comment_edit_src", i1);
          return localIntent;
        }
        i1 = 3;
        continue;
        i1 = 0;
      }
      catch (JSONException localJSONException)
      {
        return localIntent;
      }
    }
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", ors.jdField_d_of_type_Int);
      if (paramBoolean) {
        if (!this.jdField_a_of_type_Boolean) {
          break label48;
        }
      }
      label48:
      for (String str = "0";; str = "1")
      {
        localJSONObject.put("biu_comment", str);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363313));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363316));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363310));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363317));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363312));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363311));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363314));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842465);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842464);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718837), 0).a();
      return false;
    }
    if (!bdin.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718836), 0).a();
      return false;
    }
    return true;
  }
  
  /* Error */
  private Intent b()
  {
    // Byte code:
    //   0: new 209	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 212	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Ljava/lang/String;
    //   8: invokevirtual 216	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 222	bdfr:encode	([BI)[B
    //   15: invokespecial 225	java/lang/String:<init>	([B)V
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 451	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Landroid/content/Intent;
    //   24: astore 4
    //   26: new 196	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 197	org/json/JSONObject:<init>	()V
    //   33: astore_2
    //   34: aload 4
    //   36: ldc_w 419
    //   39: invokevirtual 562	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +202 -> 249
    //   50: new 196	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 565	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 237	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_l_of_type_Boolean	Z
    //   65: ifeq +57 -> 122
    //   68: aload_0
    //   69: getfield 239	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +149 -> 224
    //   78: ldc 74
    //   80: astore_3
    //   81: aload_2
    //   82: ldc 247
    //   84: aload_3
    //   85: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_2
    //   90: ldc 249
    //   92: aload_0
    //   93: getfield 251	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_m_of_type_Boolean	Z
    //   96: invokevirtual 205	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_2
    //   101: ldc 253
    //   103: aload_0
    //   104: getfield 76	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_2
    //   112: ldc 255
    //   114: aload_0
    //   115: getfield 78	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_2
    //   123: ldc 207
    //   125: aload 5
    //   127: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload_2
    //   132: ldc_w 567
    //   135: aload_0
    //   136: getfield 525	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_Boolean	Z
    //   139: invokevirtual 205	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   142: pop
    //   143: aload 4
    //   145: ldc_w 419
    //   148: aload_2
    //   149: invokevirtual 385	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokevirtual 425	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 140	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   160: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifeq +77 -> 240
    //   166: iconst_2
    //   167: istore_1
    //   168: aload 4
    //   170: ldc_w 448
    //   173: iload_1
    //   174: invokevirtual 446	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   177: pop
    //   178: aload 4
    //   180: ldc_w 427
    //   183: aload_0
    //   184: getfield 429	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   187: invokevirtual 432	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   190: pop
    //   191: ldc_w 404
    //   194: iconst_1
    //   195: new 406	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 569
    //   205: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_2
    //   209: invokevirtual 385	org/json/JSONObject:toString	()Ljava/lang/String;
    //   212: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 4
    //   223: areturn
    //   224: aload_0
    //   225: getfield 239	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: astore_3
    //   229: goto -148 -> 81
    //   232: astore_3
    //   233: aload_3
    //   234: invokevirtual 471	org/json/JSONException:printStackTrace	()V
    //   237: goto -94 -> 143
    //   240: iconst_3
    //   241: istore_1
    //   242: goto -74 -> 168
    //   245: astore_3
    //   246: goto -13 -> 233
    //   249: goto -188 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	ReadInJoyCommentComponentFragment
    //   167	75	1	i1	int
    //   33	176	2	localObject1	Object
    //   42	187	3	localObject2	Object
    //   232	2	3	localJSONException1	JSONException
    //   245	1	3	localJSONException2	JSONException
    //   24	198	4	localIntent	Intent
    //   18	108	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	59	232	org/json/JSONException
    //   61	78	245	org/json/JSONException
    //   81	122	245	org/json/JSONException
    //   122	143	245	org/json/JSONException
    //   224	229	245	org/json/JSONException
  }
  
  private void b(int paramInt)
  {
    int i3 = 2130848885;
    this.jdField_a_of_type_Int = paramInt;
    int i2 = 2130842578;
    int i1;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130842576;
      i1 = i2;
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(i1);
      }
      return;
      if (paramInt == 2)
      {
        i1 = i2;
        paramInt = i3;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
        {
          i1 = i2;
          paramInt = i3;
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            i1 = i2;
            paramInt = i3;
          }
        }
      }
      else
      {
        if (paramInt == 3)
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 24))
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
            i1 = 2130848885;
            paramInt = 2130842576;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130842576;
          i1 = i2;
          continue;
        }
        i1 = 2130848885;
        paramInt = 2130842576;
      }
    }
  }
  
  private boolean b()
  {
    return bkbq.u(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1;
  }
  
  private void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(getString(2131718790)))) {}
    for (int i1 = 2;; i1 = 1)
    {
      paramString = "";
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", ors.jdField_d_of_type_Int);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          ((JSONObject)localObject).put("consume_time", osk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
        }
        localObject = ((JSONObject)localObject).toString();
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      nrt.a(null, "", "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.jdField_e_of_type_Int), "", paramString, false);
      return;
    }
  }
  
  private void g()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("arg_comment_enable_anonymous", false)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_h_of_type_Boolean = localBundle.getBoolean("comment_can_biu", true);
    String str1 = localBundle.getString("arg_comment_placeholder", "");
    QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_placeholder : " + str1);
    if (!TextUtils.isEmpty(str1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(str1);
    }
    label121:
    SpannableStringBuilder localSpannableStringBuilder;
    for (;;)
    {
      int i1 = localBundle.getInt("arg_comment_max_length", -1);
      boolean bool;
      label168:
      Object localObject1;
      if (i1 > 0)
      {
        this.jdField_c_of_type_Int = i1;
        if (this.jdField_c_of_type_Int > 1000) {
          this.jdField_c_of_type_Int = 1000;
        }
        i1 = localBundle.getInt("arg_comment_open_at", 0);
        if ((bkbq.v(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) != 0) || (i1 != 1)) {
          break label532;
        }
        bool = true;
        this.jdField_g_of_type_Boolean = bool;
        if ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_l_of_type_Int <= 0)
        {
          this.jdField_l_of_type_Int = getResources().getDisplayMetrics().widthPixels;
          this.jdField_l_of_type_Int = (this.jdField_l_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
        }
        localObject1 = localBundle.getString("arg_comment_default_comment_at", "");
        if ((!this.jdField_g_of_type_Boolean) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label988;
        }
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localSpannableStringBuilder = new SpannableStringBuilder();
        i1 = ((JSONArray)localObject1).length() - 1;
        label296:
        if (i1 < 0) {
          break label960;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
        long l1 = ((JSONObject)localObject2).optLong("uin");
        String str4 = new String(bdfr.decode(((JSONObject)localObject2).optString("nick"), 0));
        String str3 = new String(bdfr.decode(((JSONObject)localObject2).optString("comment"), 0));
        ((JSONObject)localObject2).optString("op_type");
        long l2 = ((JSONObject)localObject2).optLong("feedsId");
        if (i1 != ((JSONArray)localObject1).length() - 1)
        {
          localObject2 = "@" + str4 + " ";
          int i2 = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject2).append(str3);
          localSpannableStringBuilder.setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_l_of_type_Int), i2, ((String)localObject2).length() + i2, 33);
        }
        for (;;)
        {
          i1 -= 1;
          break label296;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(alud.a(2131713332));
          break;
          i1 = bkbq.k(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          if (i1 <= 0) {
            break label121;
          }
          this.jdField_c_of_type_Int = i1;
          break label121;
          label532:
          bool = false;
          break label168;
          localSpannableStringBuilder.append(str3);
        }
        if (localBundle.getBoolean("arg_comment_gif_switch", true)) {
          break label1083;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    for (;;)
    {
      if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
      String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin();
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str2, 4);
      this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_native", false);
      this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_reply_second", false);
      if (this.jdField_m_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_reply_second_uin");
      }
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("comment_articleid"));
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_val");
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_author_uin");
        this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("biu_src", 1);
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("feedsType", 1);
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_id");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("first_comment_uin");
        this.jdField_i_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_is_show_pic", false))
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
      c(str1);
      this.n = localBundle.getBoolean("arg_ad_show_biu", true);
      this.p = localBundle.getBoolean("comment_type", true);
      return;
      label960:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(localSpannableStringBuilder.length());
      n();
      break;
      label988:
      str2 = localBundle.getString("arg_comment_default_txt", "");
      if (!TextUtils.isEmpty(str2))
      {
        str2 = azah.b(str2);
        if ("@".equals(str2)) {
          this.jdField_f_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(str2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(str2.length());
        n();
        break;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      break;
      label1083:
      if (bkbq.l(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_h_of_type_Int == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      nrt.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_Ahbw = null;
      n();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842465);
      }
      return;
      if (this.jdField_a_of_type_Ahbw != null) {
        nrt.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
      }
    }
  }
  
  private void j()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842356);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842355);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      ahbf localahbf = a();
      if ((localahbf != null) && (this.jdField_j_of_type_Boolean))
      {
        localahbf.c();
        this.jdField_j_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(2);
      nrt.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      ahbf localahbf = a();
      if ((localahbf != null) && (this.jdField_j_of_type_Boolean))
      {
        localahbf.c();
        this.jdField_j_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(3);
      nrt.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void m()
  {
    if (!a()) {
      return;
    }
    if (!TextUtils.isEmpty(a())) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
        i1 += 2;
      }
      for (;;)
      {
        String str = "0X800844E";
        if (this.jdField_h_of_type_Int == 1) {
          str = "0X80094A1";
        }
        nrt.a(null, "", str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(i1), "", a(true), false);
        if (this.jdField_a_of_type_Ahbw == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
          if (this.jdField_a_of_type_Ahbw != null) {
            i1 += 4;
          }
        }
        else
        {
          a(2131695735);
          a(this.jdField_a_of_type_Ahbw.jdField_b_of_type_JavaLangString);
          return;
        }
      }
    }
  }
  
  private void n()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_Ahbw == null) {
        break label44;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool1);
      }
      return;
      label44:
      bool1 = bool2;
      if (TextUtils.isEmpty(a())) {
        bool1 = false;
      }
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!rqj.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (opj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_h_of_type_Boolean = false;
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void p()
  {
    if ((oij.a()) && (this.p)) {
      this.o = true;
    }
    if (!this.o)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    q();
    s();
    v();
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    r();
  }
  
  private void r()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = oij.b().split("\\|");
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      this.jdField_m_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int])) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int]);
    }
    String str = oij.c();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    }
    if (oij.d()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      str = oij.d();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      }
      if (oij.b()) {
        a(true);
      }
    } while (!oij.c());
    if (((Boolean)bkbq.a("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
    {
      a(true);
      return;
    }
    a(false);
  }
  
  private void s()
  {
    okn localokn = new okn(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(localokn);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(localokn);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localokn);
  }
  
  private void t()
  {
    u();
    if (!a()) {
      return;
    }
    if (oij.c()) {
      bkbq.a("rij_sp_editor_last_check", Boolean.valueOf(this.jdField_b_of_type_Boolean));
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(1699, b());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", ntd.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    nrt.a(null, olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", ntd.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    nrt.a(null, olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  protected String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
    String str;
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {
      str = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "getCommentString result=" + str);
      }
      return str;
      str = UUID.randomUUID().toString();
      localObject = qqu.a(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = azah.a(qqu.b(((String)localObject).replaceAll("\n|\r\n", ""), str));
      }
    }
  }
  
  public JSONObject a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      b(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().jdField_a_of_type_Qmc = new qmc();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        oku localoku = (oku)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localoku.b);
        localJSONObject2.put("biu_feedid", new Long(localoku.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localoku.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localoku.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localoku.jdField_a_of_type_JavaLangCharSequence);
        localJSONArray.put(localJSONObject2);
        i1 += 1;
      }
      localJSONObject1.put("biuinfo", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "build article info error!");
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.clearFocus();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.c(paramInt);
      if (!this.jdField_a_of_type_Bety.isShowing()) {
        this.jdField_a_of_type_Bety.show();
      }
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.jdField_g_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) || (localObject == null));
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
      paramInt = i1;
      if (paramIntent != null)
      {
        paramInt = i1;
        if (!TextUtils.isEmpty(paramIntent.toString()))
        {
          paramInt = i1;
          if (i1 > 0)
          {
            paramInt = i1;
            if (paramIntent.toString().substring(i1 - 1, i1).equals("@"))
            {
              paramIntent.delete(i1 - 1, i1);
              paramInt = i1 - 1;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
            }
          }
        }
      }
      if (this.jdField_l_of_type_Int <= 0)
      {
        this.jdField_l_of_type_Int = getResources().getDisplayMetrics().widthPixels;
        this.jdField_l_of_type_Int = (this.jdField_l_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
      }
    } while (paramIntent == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str = "@" + BiuNicknameSpan.a(localResultRecord.jdField_b_of_type_JavaLangString) + " ";
      paramIntent.insert(paramInt, str);
      paramIntent.setSpan(new AtFriendsSpan(localResultRecord.jdField_a_of_type_JavaLangString, 0L, str, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_l_of_type_Int), paramInt, str.length() + paramInt, 33);
      paramInt = str.length() + paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(ahbw paramahbw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramahbw);
    }
    this.jdField_a_of_type_Ahbw = paramahbw;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramahbw));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      f();
      a(1, getString(2131718859));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<oku> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    String str1 = "0";
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      str1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    }
    int i2 = 0;
    int i1 = 0;
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new oku(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = qqu.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new oku(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new oku(this, str1, 0L, azah.a(qqu.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new okt(this, localEditable));
    long l1 = 0L;
    localObject3 = ((ArrayList)localObject3).iterator();
    BiuNicknameSpan localBiuNicknameSpan;
    int i4;
    int i3;
    if (((Iterator)localObject3).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject3).next();
      i4 = localEditable.getSpanStart(localBiuNicknameSpan);
      i3 = localEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label545:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = localEditable.subSequence(i2, i4).toString();
        if (localObject1 != null)
        {
          localObject1 = qqu.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (i2 != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new oku(this, str1, l1, azah.a(qqu.b((String)localObject1, str3)), i1));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          i1 = 1;
          str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
          i2 = i3;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str2 = null;
        continue;
        i1 = 0;
        continue;
      }
      try
      {
        str2 = localEditable.subSequence(i2, localEditable.length()).toString();
        if (str2 != null)
        {
          str2 = qqu.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new oku(this, str1, l1, azah.a(qqu.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), i1));
        }
        return false;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_g_of_type_Boolean) {
      b("1");
    }
    ahbf localahbf = a();
    if ((localahbf != null) && (this.jdField_j_of_type_Boolean))
    {
      localahbf.c();
      this.jdField_j_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    nrt.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  protected boolean b(ArrayList<oku> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    Object localObject1 = "0";
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (int i2 = 1;; i2 = 0)
    {
      if ((ors.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_h_of_type_Int == 1)) {}
      int i4;
      int i1;
      for (int i3 = 1;; i3 = 0)
      {
        i4 = 0;
        i1 = 0;
        if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
          break;
        }
        paramArrayList.add(new oku(this, (String)localObject1, 0L, ""));
        return false;
      }
      String str2 = UUID.randomUUID().toString();
      Object localObject4 = qqu.a(localEditable.toString(), str2).trim();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramArrayList.add(new oku(this, (String)localObject1, 0L, ""));
      }
      for (boolean bool = true;; bool = true)
      {
        if (i2 != 0)
        {
          this.jdField_d_of_type_JavaLangString = (": " + this.jdField_d_of_type_JavaLangString);
          paramArrayList.add(new oku(this, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_d_of_type_JavaLangString, 0));
        }
        if ((i3 == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList == null)) {
          break label882;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList;
        i2 = ((List)localObject1).size();
        i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label882;
          }
          localObject2 = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject1).get(i1);
          if (localObject2 != null) {
            break;
          }
          label357:
          i1 += 1;
        }
        localObject2 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
        if ((localObject2 != null) && (localObject2.length > 0)) {
          break;
        }
        str2 = azah.a(qqu.b(((String)localObject4).replaceAll("\n|\r\n", ""), str2));
        if (i2 == 0)
        {
          localObject2 = str2;
          if (i3 == 0) {}
        }
        else
        {
          localObject2 = str2 + "//";
        }
        paramArrayList.add(new oku(this, (String)localObject1, 0L, "：" + (String)localObject2));
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(Arrays.asList((Object[])localObject2));
      Collections.sort((List)localObject4, new okt(this, localEditable));
      long l1 = 0L;
      localObject4 = ((ArrayList)localObject4).iterator();
      BiuNicknameSpan localBiuNicknameSpan;
      int i6;
      int i5;
      if (((Iterator)localObject4).hasNext())
      {
        localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject4).next();
        i6 = localEditable.getSpanStart(localBiuNicknameSpan);
        i5 = localEditable.getSpanEnd(localBiuNicknameSpan);
      }
      label882:
      label885:
      for (;;)
      {
        Object localObject3;
        for (;;)
        {
          String str1;
          try
          {
            localObject2 = localEditable.subSequence(i4, i6).toString();
            if (localObject2 != null)
            {
              localObject2 = qqu.a((String)localObject2, str2).replaceAll("\n|\r\n", "");
              if (i4 != 0) {
                break label885;
              }
              localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(((String)localObject2).trim()));
              paramArrayList.add(new oku(this, (String)localObject1, l1, azah.a(qqu.b((String)localObject2, str2)), i1));
            }
            if ((localBiuNicknameSpan instanceof AtFriendsSpan))
            {
              i1 = 1;
              localObject1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
              l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
              i4 = i5;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str1 = null;
            continue;
            i1 = 0;
            continue;
          }
          try
          {
            str1 = localEditable.subSequence(i4, localEditable.length()).toString();
            if (str1 != null)
            {
              str1 = qqu.a(str1, str2).replaceAll("\n|\r\n", "");
              paramArrayList.add(new oku(this, (String)localObject1, l1, azah.a(qqu.b(str1.substring(0, str1.indexOf(str1.trim()) + str1.trim().length()), str2)), i1));
            }
            bool = false;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
              localObject3 = null;
            }
          }
        }
        paramArrayList.add(new oku(this, String.valueOf(localObject3.jdField_a_of_type_JavaLangLong), localObject3.b.longValue(), localObject3.jdField_a_of_type_JavaLangString, localObject3.jdField_c_of_type_Int));
        break label357;
        return bool;
      }
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Ahbw != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), alud.a(2131713360), 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842465);
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str = "0";; str = "1")
    {
      nrt.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842464);
      this.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  protected void d()
  {
    c(1);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected void e()
  {
    ahbf localahbf = a();
    if (localahbf != null)
    {
      if (!this.jdField_j_of_type_Boolean) {
        break label60;
      }
      localahbf.c();
      this.jdField_j_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
    for (;;)
    {
      nrt.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label60:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localahbf.a(localEditable))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), alud.a(2131713134), 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localahbf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localahbf.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
        localahbf.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      localahbf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localahbf.a(this);
      this.jdField_j_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      paramMessage = a();
      if ((paramMessage != null) && (this.jdField_j_of_type_Boolean))
      {
        paramMessage.c();
        this.jdField_j_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setSoftInputMode(17);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(0, a());
    h();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131367992: 
    default: 
      return;
    case 2131363026: 
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      return;
    case 2131367995: 
      i();
      return;
    case 2131362582: 
      j();
      return;
    case 2131365645: 
      k();
      return;
    case 2131367190: 
      l();
      return;
    case 2131365100: 
      m();
      return;
    case 2131362865: 
      b();
      return;
    case 2131380397: 
      e();
      return;
    case 2131363320: 
      c();
      return;
    }
    d();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131559934, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363026));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131367991));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367992));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367995).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362582));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365645));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367190));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368084));
    if (!asub.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362865));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364120));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365100));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131368343));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131376034));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_Bicy);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131380397));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131380400));
        a(paramLayoutInflater);
        g();
        this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_e_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131366790));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131371168);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364538));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365101));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363320));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean) {
              this.n = false;
            }
            if (this.n) {
              break label670;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (b())
            {
              this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842465);
              this.jdField_a_of_type_Boolean = true;
            }
            o();
            p();
            return paramLayoutInflater;
            this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
            break;
            paramViewGroup = paramViewGroup;
            QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
          }
          boolean bool = false;
        }
        catch (NullPointerException paramViewGroup)
        {
          for (;;)
          {
            paramViewGroup.printStackTrace();
            continue;
            label670:
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("readinjoy_comment_biu_switch", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    ahbf localahbf = a();
    if (localahbf != null) {
      localahbf.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_Bayj);
    }
    a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onFinish()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    if (this.jdField_b_of_type_Int == 1) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentComponentFragment.1(this), 300L);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    rvv.a(getActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */