import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class aqqc
  extends RecyclerView.Adapter
  implements Handler.Callback, bicx
{
  private static int jdField_b_of_type_Int;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private SparseArrayCompat<View> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqqt jdField_a_of_type_Aqqt;
  private bich jdField_a_of_type_Bich;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedsItemData.TopCardInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo;
  private QQGamePubAccountFragment jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment;
  private List<FeedsItemData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<View> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public aqqc(Context paramContext, QQAppInterface paramQQAppInterface, QQGamePubAccountFragment paramQQGamePubAccountFragment)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment = paramQQGamePubAccountFragment;
    bicy.a().a(this);
  }
  
  private List<FeedsItemData> a(List<FeedsItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedsItemData localFeedsItemData = (FeedsItemData)paramList.next();
      if ((localFeedsItemData.type == 1) || (localFeedsItemData.type == 2) || (localFeedsItemData.type == 3) || (localFeedsItemData.type == 4) || (localFeedsItemData.type == 5) || (localFeedsItemData.type == 6) || (localFeedsItemData.type == 7) || (localFeedsItemData.type == 100)) {
        localArrayList.add(localFeedsItemData);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null)) {}
    while ((TextUtils.isEmpty(paramTopCardInfo.gameInfo.gamePkgName)) || (TextUtils.isEmpty(paramTopCardInfo.gameInfo.gameIcon + paramTopCardInfo.gameInfo.gameName))) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
  }
  
  public FeedsItemData.GameInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a() == null) {
      return new FeedsItemData.GameInfo();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a();
  }
  
  public FeedsItemData a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt - a() >= 0) && (paramInt - a() < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FeedsItemData)this.jdField_a_of_type_JavaUtilList.get(paramInt - a());
    }
    return null;
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559087, null, false);
    localRelativeLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
    this.jdField_a_of_type_Aqqt = new aqqt(localRelativeLayout, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() + 100000);
    jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, localRelativeLayout);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= paramInt - a()))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt - a());
      notifyItemRemoved(paramInt);
      notifyDataSetChanged();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() + 100000, paramView);
    notifyDataSetChanged();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755255);
    Object localObject = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559091, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actj.a(280.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1);
    ((ImageView)((View)localObject).findViewById(2131368023)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_popView_card@2x.png"));
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131378394);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      localTextView1.setText(paramString2);
      localTextView1.setTextColor(aqsv.a(-16733441, 1593879295));
      ((ImageView)((View)localObject).findViewById(2131361893)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_arrow@2x.png"));
      paramString2 = (CheckBox)((View)localObject).findViewById(2131364185);
      TextView localTextView2 = (TextView)((View)localObject).findViewById(2131378096);
      TextView localTextView3 = (TextView)((View)localObject).findViewById(2131378228);
      localTextView3.setTextColor(aqsv.a(-16733441, 1593879295));
      this.jdField_a_of_type_AndroidAppDialog.setContentView((View)localObject, localLayoutParams);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      localObject = paramJSONObject.optString("app");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localTextView3.setVisibility(8);
      }
      paramString2.setOnCheckedChangeListener(new aqqf(this, paramString1));
      localTextView2.setOnClickListener(new aqqg(this, paramString4));
      localTextView1.setOnClickListener(new aqqh(this, paramString4, paramString3));
      localTextView3.setOnClickListener(new aqqi(this, paramString4, paramJSONObject, (String)localObject));
      this.jdField_a_of_type_AndroidAppDialog.show();
      paramString1 = new HashMap();
      yoa.a(paramString1, paramString4);
      paramString1.put(Integer.valueOf(2), paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        break label410;
      }
      paramString1.put(Integer.valueOf(10), "0");
    }
    for (;;)
    {
      paramString1.put(Integer.valueOf(11), "1");
      yoa.a(ajac.a(), "769", "205710", a().gameAppId, "76905", "1", "160", paramString1);
      return;
      localTextView1.setText(ajya.a(2131710329));
      break;
      label410:
      paramString1.put(Integer.valueOf(10), "1");
    }
  }
  
  public void a(List<FeedsItemData> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    for (;;)
    {
      b(this.jdField_a_of_type_JavaUtilList);
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a(List<FeedsItemData> paramList, FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    paramList = a(paramList);
    b(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        notifyItemRangeRemoved(a(), this.jdField_a_of_type_JavaUtilList.size());
      }
      c();
      this.jdField_a_of_type_JavaUtilList = paramList;
      if ((paramTopCardInfo != null) && (paramTopCardInfo.gameInfo != null)) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(paramTopCardInfo.gameInfo);
      }
    }
    label173:
    label193:
    label237:
    label243:
    label248:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
      notifyItemChanged(jdField_b_of_type_Int);
      return;
      boolean bool;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramList.size()))
      {
        int i = this.jdField_a_of_type_JavaUtilList.size();
        int j = paramList.size();
        this.jdField_a_of_type_JavaUtilList = paramList;
        notifyItemRangeChanged(a(), paramList.size());
        notifyItemRangeRemoved(a() + paramList.size(), i - j);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label243;
        }
        if (paramTopCardInfo != null) {
          break label237;
        }
        bool = true;
        a(false, bool);
      }
      for (;;)
      {
        if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null)) {
          break label248;
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(paramTopCardInfo.gameInfo);
        break;
        this.jdField_a_of_type_JavaUtilList = paramList;
        notifyDataSetChanged();
        break label173;
        bool = false;
        break label193;
        c();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      notifyItemChanged(jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      notifyItemRangeChanged(a(), this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710313));
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710315));
  }
  
  public boolean a(int paramInt)
  {
    return paramInt < a();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710316));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(2130706432);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846260);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846260);
      localObject3 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject3 = new LinearLayout.LayoutParams(actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
      localFrameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, actj.a(120.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject2 = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject2).setRepeatCount(-1);
      ((Animation)localObject2).setDuration(1000L);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710306));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201908/upload_dc6398e215f1241b9ea8b9034b7cddac.png", (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131710331));
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(2130706432);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localFrameLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
      b(localFrameLayout);
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      FrameLayout localFrameLayout;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710323));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(View paramView)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.size() + 200000, paramView);
    notifyDataSetChanged();
  }
  
  public void b(List<FeedsItemData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int j = 0;
    int i = 0;
    label18:
    FeedsItemData localFeedsItemData2;
    if (j < paramList.size())
    {
      localFeedsItemData2 = (FeedsItemData)paramList.get(j);
      if (localFeedsItemData2.type != 4) {
        break label141;
      }
      FeedsItemData localFeedsItemData1 = null;
      if (j + 1 < paramList.size()) {
        localFeedsItemData1 = (FeedsItemData)paramList.get(j + 1);
      }
      if ((localFeedsItemData1 == null) || (localFeedsItemData1.type != 4)) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = 1;; k = 0)
    {
      if (i % 2 == 0) {
        if (k != 0)
        {
          localFeedsItemData2.miniType = 0;
          label112:
          i += 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label18;
        break;
        localFeedsItemData2.miniType = 1;
        break label112;
        localFeedsItemData2.miniType = 2;
        break label112;
        i = 0;
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return paramInt >= a() + c();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    bicy.a().b(this);
    if (this.jdField_a_of_type_Bich != null) {
      bicp.b(this.jdField_a_of_type_Bich);
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12820");
    localHashSet.add("13032");
    return localHashSet;
  }
  
  public int getItemCount()
  {
    return a() + b() + c();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(paramInt);
    }
    if (b(paramInt)) {
      return this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(paramInt - a() - c());
    }
    return ((FeedsItemData)this.jdField_a_of_type_JavaUtilList.get(paramInt - a())).type;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (paramMessage.arg1 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramMessage = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      paramMessage.setRepeatCount(-1);
      paramMessage.setDuration(1000L);
      paramMessage.setRepeatMode(1);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setAnimation(paramMessage);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramMessage);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(2130706432);
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131710324));
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT, 1);
    return false;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (a(paramInt)) {
      if ((paramViewHolder instanceof aqqt)) {
        ((aqqt)paramViewHolder).a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo, this);
      }
    }
    label27:
    FeedsItemData localFeedsItemData;
    do
    {
      do
      {
        do
        {
          do
          {
            break label27;
            break label27;
            do
            {
              return;
            } while (b(paramInt));
            if ((!(paramViewHolder instanceof aqql)) && (!(paramViewHolder instanceof aqqj))) {
              break;
            }
            localFeedsItemData = a(paramInt);
          } while (localFeedsItemData == null);
          if ((localFeedsItemData.type == 1) || (localFeedsItemData.type == 2) || (localFeedsItemData.type == 3))
          {
            paramViewHolder = (aqql)paramViewHolder;
            paramViewHolder.a(this, localFeedsItemData, paramInt);
            paramViewHolder.d.setTag(a().gameAppId);
            paramViewHolder = new HashMap();
            yoa.a(paramViewHolder, localFeedsItemData.msgId);
            paramViewHolder.put(Integer.valueOf(2), localFeedsItemData.msgId);
            paramViewHolder.put(Integer.valueOf(6), localFeedsItemData.feedId);
            paramViewHolder.put(Integer.valueOf(4), "8");
            paramViewHolder.put(Integer.valueOf(43), localFeedsItemData.algorithmId);
            paramViewHolder.put(Integer.valueOf(44), localFeedsItemData.type + "");
            yoa.a(ajac.a(), "769", "205021", a().gameAppId, "76902", "1", "160", paramViewHolder);
            return;
          }
        } while (localFeedsItemData.type != 4);
        ((aqqj)paramViewHolder).a(this, localFeedsItemData, paramInt);
        paramViewHolder = new HashMap();
        yoa.a(paramViewHolder, localFeedsItemData.msgId);
        paramViewHolder.put(Integer.valueOf(2), localFeedsItemData.msgId);
        paramViewHolder.put(Integer.valueOf(6), localFeedsItemData.feedId);
        paramViewHolder.put(Integer.valueOf(4), "8");
        paramViewHolder.put(Integer.valueOf(43), localFeedsItemData.algorithmId);
        paramViewHolder.put(Integer.valueOf(44), localFeedsItemData.type + "");
        yoa.a(ajac.a(), "769", "205021", a().gameAppId, "76902", "1", "160", paramViewHolder);
        return;
      } while (!(paramViewHolder instanceof aqrt));
      localFeedsItemData = a(paramInt);
    } while (localFeedsItemData == null);
    ((aqrt)paramViewHolder).a(localFeedsItemData);
    paramViewHolder = new HashMap();
    yoa.a(paramViewHolder, localFeedsItemData.msgId);
    paramViewHolder.put(Integer.valueOf(2), localFeedsItemData.msgId);
    paramViewHolder.put(Integer.valueOf(6), localFeedsItemData.feedId);
    paramViewHolder.put(Integer.valueOf(4), "8");
    paramViewHolder.put(Integer.valueOf(43), localFeedsItemData.algorithmId);
    paramViewHolder.put(Integer.valueOf(44), localFeedsItemData.type + "");
    yoa.a(ajac.a(), "769", "205021", a().gameAppId, "76902", "1", "160", paramViewHolder);
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if ("12820".equals(paramString)) {}
    while (!"13032".equals(paramString)) {
      return;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt) != null)
    {
      if (paramInt == this.jdField_a_of_type_Int) {
        return this.jdField_a_of_type_Aqqt;
      }
      return new aqqd(this, (View)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt));
    }
    if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt) != null) {
      return new aqqe(this, (View)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt));
    }
    if (paramInt == 4)
    {
      paramViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject1).setPadding(actj.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 8.0F;
      Object localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setTextColor(-16777216);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setId(2131377350);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, actj.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject4).setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131362884);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setMaxWidth(actj.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams2.addRule(3, 2131377350);
      ((RelativeLayout)localObject2).addView((View)localObject4, localLayoutParams2);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131370992);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.leftMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams2.addRule(6, 2131362884);
      localLayoutParams2.addRule(1, 2131362884);
      ((RelativeLayout)localObject2).addView((View)localObject4, localLayoutParams2);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(10.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131366923);
      ((TextView)localObject4).setBackgroundColor(1270796256);
      ((TextView)localObject4).setPadding(actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, actj.a(-1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131362884);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new CornerImageView(this.jdField_a_of_type_AndroidContentContext);
      ((CornerImageView)localObject2).setId(2131367906);
      localLayoutParams = new LinearLayout.LayoutParams(0, actj.a(71.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.weight = 3.0F;
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramViewGroup.addView((View)localObject1, localLayoutParams1);
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, actj.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((ImageView)localObject1).setImageDrawable(new ColorDrawable(-263173));
      ((ImageView)localObject1).setId(2131365268);
      ((ImageView)localObject1).setPadding(actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
      localLayoutParams1.rightMargin = actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView((View)localObject1, localLayoutParams1);
      return new aqqj(paramViewGroup);
    }
    if ((paramInt == 5) || (paramInt == 7) || (paramInt == 6)) {
      return aqry.a(this.jdField_a_of_type_AndroidContentContext, paramInt, paramViewGroup);
    }
    return new aqql(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559086, paramViewGroup, false));
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((paramViewHolder instanceof aqql))
    {
      paramViewHolder = (aqql)paramViewHolder;
      if ((paramViewHolder.a != null) && (aqsp.a().a() == paramViewHolder.a))
      {
        paramViewHolder.a.i();
        paramViewHolder.a.l();
      }
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */