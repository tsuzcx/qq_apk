import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.vip.diy.template.ProfileCardDiyPhotoWallView;
import com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplateBase;
import com.tencent.mobileqq.vip.diy.template.TemplatePhotoWall;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdxa
{
  protected int a;
  protected Activity a;
  protected LayoutInflater a;
  protected View a;
  protected awmk a;
  protected bdxd a;
  protected String a;
  protected JSONObject a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  protected String f = "";
  
  public bdxa(Activity paramActivity, JSONObject paramJSONObject, awmk paramawmk)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Awmk = paramawmk;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    try
    {
      this.jdField_c_of_type_Int = Color.parseColor(paramJSONObject.optString("c"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sbg");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("t_bg");
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("arr");
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("f");
      this.e = paramJSONObject.optString("cbg", "");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("cpd", 0);
      this.jdField_a_of_type_Bdxd = new bdxd();
    }
    catch (IllegalArgumentException paramActivity)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Int = Color.parseColor(paramJSONObject.optString("line"));
          return;
        }
        catch (IllegalArgumentException paramActivity)
        {
          xmh.a("DIYProfileTemplate.ProfileTemplateBase default line color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
          this.jdField_a_of_type_Int = -1;
        }
        paramActivity = paramActivity;
        xmh.a("DIYProfileTemplate.ProfileTemplateBase default main color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
        this.jdField_c_of_type_Int = -16777216;
      }
    }
  }
  
  private JSONObject a(Map<String, JSONObject> paramMap, String paramString)
  {
    JSONObject localJSONObject = (JSONObject)paramMap.get(paramString);
    paramMap = localJSONObject;
    if (localJSONObject == null) {
      wsv.e("DIYProfileTemplate.ProfileTemplateBase", ":json illegal : it don't have " + paramString + " module");
    }
    try
    {
      paramMap = new JSONObject("{}");
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      xmh.a("DIYProfileTemplate.ProfileTemplateBase:json error : it can not generate default " + paramString + " module", new Object[0]);
    }
    return null;
  }
  
  private void a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(xod.b(this.jdField_a_of_type_AndroidAppActivity) - xod.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("line");
    int i = this.jdField_a_of_type_Int;
    if (TextUtils.isEmpty(str)) {
      return i;
    }
    try
    {
      int j = Color.parseColor(str);
      return j;
    }
    catch (Exception localException)
    {
      xmh.a("DIYProfileTemplate.ProfileTemplateBase story line color is illegal module=" + paramJSONObject.optString("type") + " value=" + paramJSONObject.optString("line"), new Object[0]);
    }
    return i;
  }
  
  public View a(View paramView)
  {
    if ((paramView instanceof ProfileCardFavorShowView))
    {
      localObject = (ProfileCardFavorShowView)paramView;
      ((ProfileCardFavorShowView)localObject).a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      b(null, (ProfileCardFavorShowView)localObject);
    }
    while (paramView == null) {
      return paramView;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(-1, -2);
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = xod.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = xod.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = xod.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = xod.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
    a(null, paramView);
    return paramView;
  }
  
  public View a(ETTextView paramETTextView)
  {
    paramETTextView.setTextColor(this.jdField_c_of_type_Int);
    return paramETTextView;
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    QZoneLayoutTemplateBase localQZoneLayoutTemplateBase = (QZoneLayoutTemplateBase)paramView.findViewById(2131368273);
    localQZoneLayoutTemplateBase.setBorderColor(a(paramJSONObject));
    localQZoneLayoutTemplateBase.setBorderWidth(b(paramJSONObject));
    localQZoneLayoutTemplateBase.setItemBg(a(paramJSONObject, a(70.0F), a(70.0F)));
    a(paramJSONObject, paramView.findViewById(2131367808), (TextView)paramView.findViewById(2131377706), (ImageView)paramView.findViewById(2131367950));
    return paramView;
  }
  
  public View a(JSONObject paramJSONObject, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131361832);
    Object localObject;
    if (paramView1 == null)
    {
      localObject = localViewGroup.findViewById(2131361835);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localViewGroup.setVisibility(8);
      if (paramView2 != null) {
        break label519;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373521).setVisibility(8);
      label67:
      if (paramView3 != null) {
        break label537;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373523).setVisibility(8);
      label87:
      if (paramView4 != null) {
        break label556;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373519).setVisibility(8);
    }
    for (;;)
    {
      if (localViewGroup.getChildAt(0) != null) {
        a(paramJSONObject, "qq", localViewGroup.getChildAt(0).findViewById(2131367808));
      }
      if (localViewGroup.getChildAt(1) != null) {
        a(paramJSONObject, "p", localViewGroup.getChildAt(1).findViewById(2131367808));
      }
      if (paramView1 != null)
      {
        paramView1.setPadding(a(10.0F), a(12.0F), a(10.0F), a(12.0F));
        a(paramJSONObject, paramView1);
      }
      if (this.jdField_a_of_type_Awmk.b)
      {
        paramJSONObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131361834);
        paramView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131361835);
        if (paramView2 != null) {
          paramView2.setVisibility(8);
        }
        if (paramView3 != null) {
          paramView3.setVisibility(8);
        }
        if (paramView4 != null) {
          paramView4.setVisibility(8);
        }
        if ((paramView5 != null) && (paramView5.getParent() == null))
        {
          ((TextView)paramView5.findViewById(2131368514)).setTextColor(this.jdField_c_of_type_Int);
          ((ImageView)paramView5.findViewById(2131367808)).clearColorFilter();
          ((ImageView)paramView5.findViewById(2131367808)).setColorFilter(this.jdField_c_of_type_Int);
          paramJSONObject.addView(paramView5, 0);
        }
        if ((paramView6 != null) && (paramView6.getParent() == null))
        {
          ((TextView)paramView6.findViewById(2131368514)).setTextColor(this.jdField_c_of_type_Int);
          ((ImageView)paramView6.findViewById(2131367808)).clearColorFilter();
          ((ImageView)paramView6.findViewById(2131367808)).setColorFilter(this.jdField_c_of_type_Int);
          paramJSONObject.addView(paramView6, 0);
        }
        if ((paramView7 != null) && (paramView7.getParent() == null))
        {
          ((TextView)paramView7.findViewById(2131368514)).setTextColor(this.jdField_c_of_type_Int);
          ((ImageView)paramView7.findViewById(2131367808)).clearColorFilter();
          ((ImageView)paramView7.findViewById(2131367808)).setColorFilter(this.jdField_c_of_type_Int);
          paramJSONObject.addView(paramView7, paramJSONObject.getChildCount());
        }
      }
      return paramView1;
      localObject = (TextView)localViewGroup.findViewById(2131361836);
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setTextColor(this.jdField_c_of_type_Int);
      break;
      label519:
      a(paramJSONObject, "sign", paramView2.findViewById(2131367808));
      break label67;
      label537:
      a(paramJSONObject, "lv", paramView3.findViewById(2131367808));
      break label87;
      label556:
      a(paramJSONObject, "metal", paramView4.findViewById(2131367808));
    }
  }
  
  protected URLDrawable a(String paramString)
  {
    return a(paramString, null);
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    paramString = a(paramString);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = baul.a;
    localURLDrawableOptions.mFailedDrawable = baul.a;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  protected URLDrawable a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.e; TextUtils.isEmpty(paramJSONObject); paramJSONObject = paramJSONObject.optString("cbg", this.e)) {
      return null;
    }
    return a(paramJSONObject, new bdxc(paramInt1, paramInt2));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131561792);
  }
  
  protected String a(@NonNull String paramString)
  {
    if (paramString.startsWith("http")) {}
    while (TextUtils.isEmpty(this.f)) {
      return paramString;
    }
    if (this.f.startsWith("http")) {
      return this.f + paramString;
    }
    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, "it have the illegal url prefix=" + this.f);
    return paramString;
  }
  
  protected String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return this.e;
    }
    return paramJSONObject.optString("cbg", this.e);
  }
  
  public List<View> a(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("module");
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      xmh.a("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
      return localArrayList;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    JSONObject localJSONObject1;
    if (i < ((JSONArray)localObject).length())
    {
      localJSONObject1 = ((JSONArray)localObject).optJSONObject(i);
      if (localJSONObject1 == null) {
        wsv.e("DIYProfileTemplate.ProfileTemplateBase", "module array[" + i + "] is null");
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(localJSONObject1.optString("type"), localJSONObject1);
      }
    }
    int j = 0;
    i = 0;
    if (i < paramArrayOfString.length)
    {
      localJSONObject1 = null;
      if ((paramArrayOfString[i].equals("map_key_account_base_info")) || (paramArrayOfString[i].equals("map_key_sig")) || (paramArrayOfString[i].equals("map_key_account_level_info")) || (paramArrayOfString[i].equals("map_key_medal_and_diamond")) || (paramArrayOfString[i].equals("map_key_troop_mem_add_time")) || (paramArrayOfString[i].equals("map_key_troop_mem_charm_level")) || (paramArrayOfString[i].equals("map_key_troop_mem_recent_said")))
      {
        if (j != 0) {
          break label713;
        }
        localObject = a(a(localHashMap, "info"), (View)paramHashMap.get("map_key_account_base_info"), (View)paramHashMap.get("map_key_sig"), (View)paramHashMap.get("map_key_account_level_info"), (View)paramHashMap.get("map_key_medal_and_diamond"), (View)paramHashMap.get("map_key_troop_mem_add_time"), (View)paramHashMap.get("map_key_troop_mem_charm_level"), (View)paramHashMap.get("map_key_troop_mem_recent_said"));
        j = 1;
      }
    }
    for (;;)
    {
      label329:
      if (localObject != null) {
        if (((View)localObject).getParent() != null) {
          break label704;
        }
      }
      label704:
      for (boolean bool = true;; bool = false)
      {
        xmh.a(bool, "makeModuleList error :" + paramArrayOfString[i] + " have a parent!");
        localArrayList.add(localObject);
        i += 1;
        break;
        if (paramArrayOfString[i].equals("map_key_qzone"))
        {
          localObject = a(a(localHashMap, "qz"), (View)paramHashMap.get("map_key_qzone"));
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_photo_wall"))
        {
          localObject = c(a(localHashMap, "photo"), (View)paramHashMap.get("map_key_photo_wall"));
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_personality_label_board"))
        {
          localObject = d(a(localHashMap, "tag"), (View)paramHashMap.get("map_key_personality_label_board"));
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_extend_friend_info"))
        {
          localObject = e(a(localHashMap, "exp"), (View)paramHashMap.get("map_key_extend_friend_info"));
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_favor"))
        {
          localObject = f(a(localHashMap, "recent"), (View)paramHashMap.get("map_key_favor"));
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_present"))
        {
          localObject = null;
          break label329;
        }
        if (paramArrayOfString[i].equals("map_key_music_box"))
        {
          JSONObject localJSONObject2 = a(localHashMap, "qz");
          localObject = localJSONObject1;
          if (awom.a(this.jdField_a_of_type_Awmk))
          {
            localObject = localJSONObject1;
            if (paramHashMap.containsKey("map_key_music_box")) {
              localObject = b(localJSONObject2, (View)paramHashMap.get("map_key_music_box"));
            }
          }
          break label329;
        }
        localObject = a((View)paramHashMap.get(paramArrayOfString[i]));
        break label329;
      }
      return localArrayList;
      label713:
      localObject = null;
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (("map_key_phone".equals(paramString)) || ("map_key_sig".equals(paramString)) || ("map_key_mine_weishi".equals(paramString)) || ("map_key_favor".equals(paramString)) || ("map_key_account_base_info".equals(paramString)))
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.jdField_c_of_type_Int);
      }
      if (!(paramView instanceof TextView)) {
        break label81;
      }
      ((TextView)paramView).setTextColor(this.jdField_c_of_type_Int);
    }
    label81:
    do
    {
      return;
      if ((paramView instanceof SingleLineTextView))
      {
        ((SingleLineTextView)paramView).setTextColor(this.jdField_c_of_type_Int);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setColorFilter(this.jdField_c_of_type_Int);
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561799, null);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    Object localObject = localMarginLayoutParams;
    if (localMarginLayoutParams == null) {
      localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(a(11.0F), a(11.0F), a(11.0F), a(11.0F));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramHashMap.put("map_key_account_base_info", this.jdField_a_of_type_AndroidViewView);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373521);
    ((View)localObject).setBackgroundResource(2130839255);
    paramHashMap.put("map_key_sig", localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373523);
    ((View)localObject).setBackgroundResource(2130839255);
    paramHashMap.put("map_key_account_level_info", localObject);
    ((View)localObject).setClickable(false);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373519);
    ((View)localObject).setBackgroundResource(2130839255);
    paramHashMap.put("map_key_medal_and_diamond", localObject);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, awmk paramawmk)
  {
    ProfileCardFavorShowView localProfileCardFavorShowView = a(this.jdField_a_of_type_AndroidAppActivity);
    paramQQAppInterface = new PersonalityLabelBoard(this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface, paramawmk.a.jdField_a_of_type_JavaLangString, localProfileCardFavorShowView);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FriendProfileCardActivity)) {
      paramQQAppInterface.setScrollListener((awku)this.jdField_a_of_type_AndroidAppActivity);
    }
    localProfileCardFavorShowView.setTitle(alpo.a(2131708879));
    localProfileCardFavorShowView.setVisibility(8);
    localProfileCardFavorShowView.addView(paramQQAppInterface);
    paramHashMap.put("map_key_personality_label_board", localProfileCardFavorShowView);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, awmk paramawmk, bens parambens)
  {
    paramQQAppInterface = new TemplatePhotoWall(this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface, paramawmk.a.jdField_a_of_type_JavaLangString, parambens);
    paramawmk = (ProfileCardDiyPhotoWallView)paramQQAppInterface.findViewById(2131371899).findViewById(2131371899);
    paramawmk.setMargin(xod.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    paramawmk.setBorderWidth(this.jdField_d_of_type_Int);
    paramawmk = a(this.jdField_a_of_type_AndroidAppActivity);
    paramawmk.setTitle(alpo.a(2131708880));
    paramawmk.setVisibility(8);
    paramawmk.addView(paramQQAppInterface);
    paramHashMap.put("map_key_photo_wall", paramawmk);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, awmk paramawmk, boolean paramBoolean)
  {
    paramQQAppInterface = a(this.jdField_a_of_type_AndroidAppActivity);
    paramQQAppInterface.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131691204));
    paramQQAppInterface.setVisibility(8);
    paramQQAppInterface.setOnClickListener(null);
    if (paramBoolean) {
      paramQQAppInterface.setShowArrow(false);
    }
    paramHashMap.put("map_key_extend_friend_info", paramQQAppInterface);
  }
  
  public void a(HashMap<String, View> paramHashMap, Card paramCard)
  {
    awom localawom = new awom(true);
    paramCard = localawom.a(this.jdField_a_of_type_AndroidAppActivity, paramCard.uin);
    localawom.a(this.jdField_a_of_type_Awmk);
    paramCard.setTag(2131561811, localawom);
    paramHashMap.put("map_key_music_box", paramCard);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return;
    }
    a(paramView);
    a(paramJSONObject, paramView, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, int paramInt1, int paramInt2)
  {
    String str;
    if (paramJSONObject == null)
    {
      str = this.jdField_a_of_type_JavaLangString;
      if (paramJSONObject != null) {
        break label74;
      }
    }
    label74:
    for (paramJSONObject = "null module";; paramJSONObject = paramJSONObject.optString("type"))
    {
      if (!TextUtils.isEmpty(str)) {
        break label84;
      }
      wsv.d("DIYProfileTemplate.ProfileTemplateBase", "setModuleBackground " + paramJSONObject + " ,but it is null.");
      return;
      str = paramJSONObject.optString("bg", this.jdField_a_of_type_JavaLangString);
      break;
    }
    label84:
    if (paramView == null)
    {
      xmh.a("setModuleBackground cant find " + paramJSONObject + " view", new Object[0]);
      return;
    }
    try
    {
      URLDrawable localURLDrawable = a(str, new bdxc(paramInt1, paramInt2));
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new bdxb(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      xmh.a("setModuleBackground " + paramJSONObject + " url illegal:" + str + " \ne:" + paramView, new Object[0]);
    }
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if (paramView != null)
    {
      String str = b(paramJSONObject);
      if (!TextUtils.isEmpty(str)) {
        paramView.setBackgroundDrawable(a(str));
      }
    }
    else if (paramImageView != null)
    {
      paramView = c(paramJSONObject);
      if (TextUtils.isEmpty(paramView)) {
        break label114;
      }
      paramImageView.setImageDrawable(a(paramView));
    }
    for (;;)
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.jdField_c_of_type_Int);
      }
      return;
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
      }
      paramView.setVisibility(8);
      break;
      label114:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
      }
      paramImageView.setVisibility(8);
    }
  }
  
  public void a(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    if (paramProfileCardFavorShowView.b() > 0)
    {
      View localView = paramProfileCardFavorShowView.a(0);
      a(localView);
      a(paramJSONObject, paramProfileCardFavorShowView.a(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
    }
    for (;;)
    {
      a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131367808), (TextView)paramProfileCardFavorShowView.findViewById(2131377706), (ImageView)paramProfileCardFavorShowView.findViewById(2131367950));
      return;
      a(paramJSONObject, paramProfileCardFavorShowView.a());
    }
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, View paramView)
  {
    paramJSONObject = paramJSONObject.optString(paramString);
    if (TextUtils.isEmpty(paramJSONObject))
    {
      wsv.d("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon " + paramString + " icon,but it is null.");
      return;
    }
    if (paramView == null)
    {
      wsv.e("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon cant find " + paramString + " view");
      return;
    }
    try
    {
      URLDrawable localURLDrawable = a(paramJSONObject);
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new bdxb(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      xmh.a("setBaseInfoIcon " + paramString + " url illegal:" + paramJSONObject + " \ne:" + paramView, new Object[0]);
    }
  }
  
  protected int b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (int i = this.jdField_b_of_type_Int; i == 0; i = paramJSONObject.optInt("cpd", this.jdField_b_of_type_Int)) {
      return this.jdField_d_of_type_Int;
    }
    return a(i / 2);
  }
  
  public View b(JSONObject paramJSONObject, View paramView)
  {
    View localView = paramView.findViewById(2131368247);
    Object localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = a(15.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = a(15.0F);
    ((LinearLayout.LayoutParams)localObject1).height = a(74.0F);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramView.findViewById(2131367808);
    Object localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = a(16.0F);
    ((LinearLayout.LayoutParams)localObject2).height = a(28.0F);
    ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (TextView)paramView.findViewById(2131377706);
    ((TextView)localObject2).setTextSize(1, 20.0F);
    ((TextView)localObject2).setTypeface(((TextView)localObject2).getTypeface(), 1);
    ImageView localImageView = (ImageView)paramView.findViewById(2131367950);
    localImageView.getLayoutParams().width = a(18.0F);
    localImageView.getLayoutParams().height = a(18.0F);
    localImageView.setLayoutParams(localImageView.getLayoutParams());
    Object localObject3 = (TextView)paramView.findViewById(2131376824);
    ((TextView)localObject3).setTextColor(this.jdField_c_of_type_Int);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
    localLayoutParams.topMargin = a(22.0F);
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    localObject3 = paramView.findViewById(2131376960);
    localLayoutParams = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
    localLayoutParams.topMargin = a(19.0F);
    localLayoutParams.leftMargin = a(19.0F);
    ((View)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)paramView.findViewById(2131365753)).setTextColor(this.jdField_c_of_type_Int);
    localObject3 = (TextView)paramView.findViewById(2131376823);
    ((TextView)localObject3).setTextColor(this.jdField_c_of_type_Int);
    ((TextView)localObject3).setAlpha(0.2509804F);
    a(paramJSONObject, (View)localObject1, (TextView)localObject2, localImageView);
    a(paramJSONObject, localView);
    if (paramView.getTag(2131561811) != null) {
      ((awom)paramView.getTag(2131561811)).a(this.jdField_a_of_type_Awmk);
    }
    return paramView;
  }
  
  protected String b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.jdField_b_of_type_JavaLangString;; paramJSONObject = paramJSONObject.optString("t_bg"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      return localObject;
    }
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561800, null));
  }
  
  public void b(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    a(paramJSONObject, paramProfileCardFavorShowView.a());
    a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131367808), (TextView)paramProfileCardFavorShowView.findViewById(2131377706), (ImageView)paramProfileCardFavorShowView.findViewById(2131367950));
  }
  
  public View c(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    Object localObject;
    PhotoWallView localPhotoWallView;
    do
    {
      return paramView;
      localObject = (ProfileCardFavorShowView)paramView;
      localPhotoWallView = (PhotoWallView)((ProfileCardFavorShowView)localObject).a(0);
      ProfileCardDiyPhotoWallView localProfileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView)localPhotoWallView.findViewById(2131371899).findViewById(2131371899);
      localProfileCardDiyPhotoWallView.setItemViewBorderColor(a(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderImgUrl(a(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderWidth(b(paramJSONObject));
      a(paramJSONObject, ((ProfileCardFavorShowView)localObject).findViewById(2131367808), (TextView)((ProfileCardFavorShowView)localObject).findViewById(2131377706), (ImageView)((ProfileCardFavorShowView)localObject).findViewById(2131367950));
      localObject = localPhotoWallView.findViewById(2131371891);
    } while (((View)localObject).getVisibility() != 0);
    ((View)localObject).setPadding(a(10.0F), a(15.0F), a(10.0F), a(10.0F));
    a(localPhotoWallView);
    a(paramJSONObject, (View)localObject, localPhotoWallView.getMeasuredWidth(), localPhotoWallView.getMeasuredHeight());
    return paramView;
  }
  
  protected String c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.jdField_c_of_type_JavaLangString;; paramJSONObject = paramJSONObject.optString("arr"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.jdField_c_of_type_JavaLangString;
      }
      return localObject;
    }
  }
  
  public View d(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
    localProfileCardFavorShowView.a().setPadding(a(24.0F), a(21.0F), a(24.0F), a(21.0F));
    try
    {
      ((PersonalityLabelBoard)localProfileCardFavorShowView.a(0)).a.setTextColor(this.jdField_c_of_type_Int);
      if (localProfileCardFavorShowView.b() > 0)
      {
        View localView = localProfileCardFavorShowView.a(0);
        localView.measure(View.MeasureSpec.makeMeasureSpec(xod.b(this.jdField_a_of_type_AndroidAppActivity) - xod.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        a(paramJSONObject, localProfileCardFavorShowView.a(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
        a(paramJSONObject, localProfileCardFavorShowView.findViewById(2131367808), (TextView)localProfileCardFavorShowView.findViewById(2131377706), (ImageView)localProfileCardFavorShowView.findViewById(2131367950));
        return paramView;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wsv.e("DIYProfileTemplate.ProfileTemplateBase", "getTagView error personalityLabelBoard is null");
        continue;
        a(paramJSONObject, localProfileCardFavorShowView.a());
      }
    }
  }
  
  public View e(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    do
    {
      return paramView;
      ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
      localProfileCardFavorShowView.a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      a(paramJSONObject, localProfileCardFavorShowView);
      paramJSONObject = localProfileCardFavorShowView.a(0);
      if (paramJSONObject == null) {
        return null;
      }
    } while (!(paramJSONObject instanceof ProfileCardExtendFriendView));
    paramJSONObject = (ProfileCardExtendFriendView)paramJSONObject;
    return paramView;
  }
  
  public View f(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof LinearLayout)) {
      return paramView;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    int i = 0;
    label17:
    Object localObject;
    if (i < localLinearLayout.getChildCount())
    {
      localObject = localLinearLayout.getChildAt(i);
      if ((localObject instanceof ProfileCardFavorShowView)) {
        break label49;
      }
    }
    for (;;)
    {
      i += 1;
      break label17;
      break;
      label49:
      localObject = (ProfileCardFavorShowView)localObject;
      ((ProfileCardFavorShowView)localObject).a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      b(paramJSONObject, (ProfileCardFavorShowView)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxa
 * JD-Core Version:    0.7.0.1
 */