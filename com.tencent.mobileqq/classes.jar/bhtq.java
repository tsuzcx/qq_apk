import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindow.3;
import com.tencent.widget.NegativeChildrenLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class bhtq
  extends PopupWindow
{
  public final int a;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bhts(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bhtu jdField_a_of_type_Bhtu;
  bhtv jdField_a_of_type_Bhtv = new bhtt(this);
  NegativeChildrenLayout jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
  public final String a;
  ArrayList<DislikeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap(6);
  public final int b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public final String b;
  ArrayList<DislikeInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public final int c;
  View jdField_c_of_type_AndroidViewView;
  String jdField_c_of_type_JavaLangString = "";
  ArrayList<DislikeInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  public final int d;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString = "";
  ArrayList<DislikeInfo> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public final int e;
  View jdField_e_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  public final int f;
  View jdField_f_of_type_AndroidViewView;
  ArrayList<View> jdField_f_of_type_JavaUtilArrayList = new ArrayList();
  public final int g = 3;
  public int h = -1;
  public int i;
  public int j;
  public int k;
  int l;
  public int m;
  int n = 0;
  protected int o;
  protected int p;
  protected int q;
  int r;
  
  public bhtq(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "KandianNegativeWindow";
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 5;
    this.jdField_e_of_type_Int = 8;
    this.jdField_f_of_type_Int = 9;
    this.jdField_b_of_type_JavaLangString = alpo.a(2131706297);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560080, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private String a(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= paramArrayList.size()) || (i1 >= 3)) {
        return localStringBuilder.toString();
      }
      if (!TextUtils.isEmpty(((DislikeInfo)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString))
      {
        if (i1 != 0) {
          localStringBuilder.append("、");
        }
        localStringBuilder.append(((DislikeInfo)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      }
      i1 += 1;
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    paramView = this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
    float f2;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
      paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      f2 = -1.0F;
    }
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(1, f1, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation1.setDuration(300L);
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(1, 0.0F, 1, f2, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      ((View)localObject).startAnimation(localTranslateAnimation1);
      paramView.startAnimation(localTranslateAnimation2);
      return;
      f2 = 1.0F;
    }
  }
  
  private void a(Object paramObject, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("folder_status", ors.jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", ors.e());
      localJSONObject.put("feeds_type", "" + this.q);
      localJSONObject.put("channel_id", this.p + "");
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = "";
      }
      localJSONObject.put("rowkey", this.jdField_d_of_type_JavaLangString);
      paramObject = (DislikeInfo)paramObject;
      if (paramObject != null)
      {
        localJSONObject.put("tag_id", paramObject.jdField_a_of_type_Long + "");
        localJSONObject.put("tag_name", paramObject.jdField_a_of_type_JavaLangString);
        if (paramBoolean) {
          this.jdField_c_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
        }
      }
    }
    catch (Exception paramObject)
    {
      label191:
      break label191;
    }
    nrt.a(null, "", "0X8009990", "0X8009990", 0, 0, String.valueOf(this.r), "", this.jdField_c_of_type_JavaLangString, localJSONObject.toString(), false);
  }
  
  private boolean a(View paramView, int[] paramArrayOfInt)
  {
    int i1 = b();
    paramView.getLocationOnScreen(paramArrayOfInt);
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramArrayOfInt[0];
    int i3 = paramArrayOfInt[1];
    boolean bool;
    if (paramArrayOfInt[1] + i1 + paramView.getHeight() <= this.j)
    {
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 8);
      setAnimationStyle(2131755035);
      bool = false;
      b(paramView, bool);
      c(paramView, bool);
      paramArrayOfInt[0] = ((this.i - this.k) / 2);
      if ((this.h > 0) && (this.j > 0)) {
        break label175;
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new KandianNegativeWindow.3(this, localStringBuilder, i2, i3, true));
      return true;
      setAnimationStyle(2131755038);
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 - i1 - paramView.getHeight() / 8);
      bool = true;
      break;
      label175:
      if ((paramArrayOfInt[0] <= 0) || (paramArrayOfInt[1] <= 0) || (this.m > 0)) {}
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[0] < this.i * 2 / 3) {}
    for (;;)
    {
      if (paramBoolean) {
        if (i1 != 0) {
          i1 = 2131755037;
        }
      }
      for (;;)
      {
        setAnimationStyle(i1);
        return;
        i1 = 2131755038;
        continue;
        if (i1 != 0) {
          i1 = 2131755034;
        } else {
          i1 = 2131755035;
        }
      }
      i1 = 1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
    if (paramBoolean) {
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(10);
    }
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i1 = localObject[0];
    int i2 = paramView.getWidth() / 2;
    int i3 = this.l;
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    if (!paramBoolean) {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = (i1 + i2 - i3 - paramView.getWidth() / 5);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      b(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void e()
  {
    d();
    int i1 = this.jdField_f_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      if (i1 <= 1) {
        ((View)this.jdField_f_of_type_JavaUtilArrayList.get(0)).setBackgroundResource(2130842556);
      }
    }
    else {
      return;
    }
    ((View)this.jdField_f_of_type_JavaUtilArrayList.get(0)).setBackgroundResource(2130842558);
    ((View)this.jdField_f_of_type_JavaUtilArrayList.get(i1 - 1)).setBackgroundResource(2130842557);
  }
  
  protected int a()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = i2;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > i2) {
      i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
    }
    i2 = i1;
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > i1) {
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
    }
    i1 = i2;
    if (this.jdField_d_of_type_JavaUtilArrayList.size() > i2) {
      i1 = this.jdField_d_of_type_JavaUtilArrayList.size();
    }
    i2 = i1;
    if (i1 > 6) {
      i2 = 6;
    }
    return i2;
  }
  
  protected void a()
  {
    setHeight(b());
    e();
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    b();
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    this.jdField_d_of_type_JavaLangString = paramString;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
        if (localDislikeInfo != null)
        {
          switch (localDislikeInfo.jdField_c_of_type_Int)
          {
          }
          for (;;)
          {
            QLog.e("KandianNegativeWindow", 1, "dislikeInfo," + localDislikeInfo.toString());
            break;
            this.jdField_a_of_type_JavaUtilArrayList.add(localDislikeInfo);
            continue;
            if (TextUtils.isEmpty(localDislikeInfo.jdField_a_of_type_JavaLangString))
            {
              String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localDislikeInfo.jdField_a_of_type_Long));
              paramString = str;
              if (str == null) {
                paramString = "";
              }
              localDislikeInfo.jdField_a_of_type_JavaLangString = paramString;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(localDislikeInfo);
            continue;
            this.jdField_c_of_type_JavaUtilArrayList.add(localDislikeInfo);
          }
        }
      }
    }
    for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
    {
      paramArrayList = new DislikeInfo();
      paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramArrayList.jdField_c_of_type_Int = 9;
      paramArrayList.jdField_b_of_type_JavaLangString = "";
      this.jdField_d_of_type_JavaUtilArrayList.add(paramArrayList);
      paramArrayList = new DislikeInfo();
      paramArrayList.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131718912);
      paramArrayList.jdField_c_of_type_Int = 8;
      paramArrayList.jdField_b_of_type_JavaLangString = "";
      this.jdField_e_of_type_JavaUtilArrayList.add(paramArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_AndroidViewView, 2130841343, alpo.a(2131706303), true);
      a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_AndroidViewView, 2130841347, alpo.a(2131706313), true);
      a(this.jdField_c_of_type_JavaUtilArrayList, this.jdField_d_of_type_AndroidViewView, 2130841336, a(this.jdField_c_of_type_JavaUtilArrayList), false);
      a(this.jdField_d_of_type_JavaUtilArrayList, this.jdField_e_of_type_AndroidViewView, 2130841340, alpo.a(2131706309), false);
      a(this.jdField_e_of_type_JavaUtilArrayList, this.jdField_f_of_type_AndroidViewView, 2130841335, BaseApplicationImpl.getContext().getString(2131718912), false);
      a();
      QLog.e("KandianNegativeWindow", 1, "setData,size:" + paramInt1);
      return;
    }
  }
  
  protected void a(int paramInt, View paramView)
  {
    if (paramInt > 0) {
      this.jdField_f_of_type_JavaUtilArrayList.add(paramView);
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371022);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371018);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371024);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371021);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131371020);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371025));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371026));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364264));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370007));
    ((ImageView)paramView.findViewById(2131366382).findViewById(2131369331)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i = ((int)bdcb.i());
    this.j = ((int)bdcb.j());
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298618));
    this.k = (this.i - this.l * 2);
    setWidth(this.k);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364770));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(1L), alpo.a(2131706310));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(2L), alpo.a(2131706308));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(3L), alpo.a(2131706299));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(4L), alpo.a(2131706300));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(5L), alpo.a(2131706305));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(6L), alpo.a(2131706304));
    this.m = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298594));
    this.jdField_e_of_type_AndroidViewView.findViewById(2131376388).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    setOnDismissListener(new bhtr(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(View paramView, bhtu parambhtu)
  {
    if (isShowing()) {
      dismiss();
    }
    this.jdField_a_of_type_Bhtu = parambhtu;
    parambhtu = new int[2];
    try
    {
      bool = a(paramView, parambhtu);
      if (bool)
      {
        showAtLocation(paramView, 51, parambhtu[0], parambhtu[1]);
        a(0.8F);
        a(this);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public void a(PopupWindow paramPopupWindow)
  {
    try
    {
      View localView;
      if (Build.VERSION.SDK_INT >= 23)
      {
        localView = (View)paramPopupWindow.getContentView().getParent();
        if (paramPopupWindow.getBackground() == null) {
          break label95;
        }
        localView = (View)localView.getParent();
      }
      for (;;)
      {
        paramPopupWindow = (WindowManager)paramPopupWindow.getContentView().getContext().getSystemService("window");
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
        localLayoutParams.flags |= 0x2;
        localLayoutParams.dimAmount = 0.2F;
        paramPopupWindow.updateViewLayout(localView, localLayoutParams);
        return;
        localView = paramPopupWindow.getContentView();
        break;
      }
    }
    catch (Exception paramPopupWindow) {}
  }
  
  protected void a(ArrayList<DislikeInfo> paramArrayList, View paramView, int paramInt, String paramString, boolean paramBoolean)
  {
    int i1 = 8;
    int i2 = i1;
    TextView localTextView;
    ImageView localImageView;
    if (!paramArrayList.isEmpty())
    {
      i2 = i1;
      if (!TextUtils.isEmpty(paramString))
      {
        ((TextView)paramView.findViewById(2131368566)).setText(paramString);
        localTextView = (TextView)paramView.findViewById(2131368562);
        localImageView = (ImageView)paramView.findViewById(2131368551);
        ((ImageView)paramView.findViewById(2131368507)).setImageResource(paramInt);
        paramString = "";
        if (!paramBoolean) {
          break label150;
        }
        paramArrayList = a(paramArrayList);
        paramView.setTag(null);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramArrayList)) {
        i1 = 0;
      }
      localImageView.setVisibility(i1);
      localTextView.setText(paramArrayList);
      localTextView.setVisibility(i1);
      this.n += 1;
      i2 = 0;
      paramView.setVisibility(i2);
      return;
      label150:
      paramView.setTag(paramArrayList.get(0));
      paramArrayList = paramString;
    }
  }
  
  public void a(pgq parampgq, ArrayList<DislikeInfo> paramArrayList)
  {
    int i2 = 0;
    String str = null;
    if (parampgq != null) {}
    for (;;)
    {
      try
      {
        i1 = parampgq.jdField_b_of_type_Int;
        i2 = parampgq.jdField_a_of_type_Int;
        parampgq = parampgq.a();
        int i3 = ors.a(parampgq);
        str = "";
        if (parampgq != null) {
          str = parampgq.innerUniqueID;
        }
        a(i1, i2, i3, paramArrayList, str);
        return;
      }
      catch (Exception parampgq)
      {
        return;
      }
      int i1 = 0;
      parampgq = str;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i2 = 8;
    int i1 = 0;
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(i2);
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(i1);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout, paramBoolean);
        return;
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean);
      return;
      i2 = 0;
      i1 = 8;
    }
  }
  
  protected int b()
  {
    if (this.h <= 0)
    {
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      this.h = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    }
    int i1 = (a() + 1) * this.m + this.h;
    b(this.jdField_b_of_type_AndroidViewView);
    int i2 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() * this.n + this.h;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_f_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n = 0;
  }
  
  protected void b(View paramView)
  {
    paramView.measure(0, 0);
  }
  
  protected void c()
  {
    dismiss();
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bhtu == null);
      paramView = paramView.getTag();
    } while (!(paramView instanceof DislikeInfo));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((DislikeInfo)paramView);
    this.jdField_a_of_type_Bhtu.a(null, this.o, localArrayList, null);
  }
  
  protected void d()
  {
    this.jdField_f_of_type_JavaUtilArrayList.clear();
    a(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_b_of_type_AndroidViewView);
    a(this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_c_of_type_AndroidViewView);
    a(this.jdField_c_of_type_JavaUtilArrayList.size(), this.jdField_d_of_type_AndroidViewView);
    a(this.jdField_d_of_type_JavaUtilArrayList.size(), this.jdField_e_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhtq
 * JD-Core Version:    0.7.0.1
 */