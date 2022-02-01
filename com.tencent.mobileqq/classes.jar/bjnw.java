import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet.10;
import com.tencent.widget.ActionSheet.5;
import com.tencent.widget.ActionSheet.6;
import com.tencent.widget.ActionSheet.7;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class bjnw
  extends ReportDialog
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Resources a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjoe jdField_a_of_type_Bjoe;
  private bjof jdField_a_of_type_Bjof;
  private bjog jdField_a_of_type_Bjog;
  private bjoi jdField_a_of_type_Bjoi;
  private bjoj jdField_a_of_type_Bjoj;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public Object a;
  private ArrayList<Pair<CharSequence, Integer>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<CharSequence, bjnv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, bjoh> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Map<Integer, URLDrawable> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public boolean c;
  private int jdField_d_of_type_Int = 300;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new bjoc(this);
  private HashMap<Integer, Integer> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  protected boolean d;
  private HashMap<Integer, String> jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  protected bjnw(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected bjnw(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true, -1, null);
  }
  
  @TargetApi(14)
  protected bjnw(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramContext, 2131755230);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bjod(this);
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 14) {
      localWindow.setDimAmount(0.5F);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localWindow.addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      localWindow.setFlags(1024, 1024);
    }
    ImmersiveUtils.a(localWindow, true);
    paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater;
    if (paramInt != -1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.inflate(paramInt, null));
      if (paramLayoutParams == null) {
        break label370;
      }
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup, paramLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361964));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361972));
      this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      return;
      paramInt = 2131558436;
      break;
      label370:
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public static bjnw a(Context paramContext)
  {
    paramContext = new bjnw(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static bjnw a(Context paramContext, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = new bjnw(paramContext, false, false, true, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static bjnw a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new bjnw(paramContext, false, true, paramBoolean, -1, null);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  private CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    paramCharSequence = new SpannableStringBuilder("icon" + paramCharSequence);
    paramDrawable.setBounds(0, 0, ViewUtils.dip2px(20.0F), ViewUtils.dip2px(20.0F));
    paramDrawable = new VerticalCenterImageSpan(paramDrawable, 0);
    paramDrawable.setPadding(ViewUtils.dip2px(6.5F), ViewUtils.dip2px(6.5F));
    paramCharSequence.setSpan(paramDrawable, 0, "icon".length(), 18);
    return paramCharSequence;
  }
  
  private void a(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramPair == null) || (paramTextView == null)) {}
    while (((Integer)paramPair.second).intValue() != 11) {
      return;
    }
    paramTextView.setTextSize(12.0F);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(2131691017) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131691019) + paramTextView.getText());
  }
  
  private void a(URLDrawable paramURLDrawable, Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramURLDrawable == null) || (paramPair == null) || (paramTextView == null)) {
      return;
    }
    paramURLDrawable.setURLDrawableListener(new bjnz(this, paramTextView, paramPair));
    paramURLDrawable.setDownloadListener(new bjoa(this));
    ThreadManagerV2.executeOnSubThread(new ActionSheet.5(this, paramURLDrawable));
  }
  
  private void a(CharSequence paramCharSequence, bjoh parambjoh)
  {
    if ((paramCharSequence == null) || (parambjoh == null)) {
      return;
    }
    int j = paramCharSequence.hashCode();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), parambjoh);
  }
  
  public static bjnw b(Context paramContext)
  {
    paramContext = new bjnw(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  private void b(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramPair == null) || (paramTextView == null)) {}
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        do
        {
          return;
        } while ((((Integer)paramPair.second).intValue() != 10) || (paramPair.first == null));
        a((CharSequence)paramPair.first, new bjny(this, paramTextView));
      } while (!this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(((CharSequence)paramPair.first).hashCode())));
      localURLDrawable = (URLDrawable)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((CharSequence)paramPair.first).hashCode()));
    } while (localURLDrawable == null);
    QLog.i("ActionSheet", 1, "prepareContentViews " + localURLDrawable);
    if (localURLDrawable.getStatus() == 1)
    {
      paramTextView.setText(a((CharSequence)paramPair.first, localURLDrawable));
      return;
    }
    a(localURLDrawable, paramPair, paramTextView);
  }
  
  public static bjnw c(Context paramContext)
  {
    paramContext = new bjnw(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static bjnw d(Context paramContext)
  {
    paramContext = new bjnw(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), null);
      ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837572));
      ((View)localObject1).setOnClickListener(new bjnx(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131361983));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131361980);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject2).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0);
    }
    for (int j = 1;; j = 0)
    {
      if (this.f) {
        j = 1;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int k = j + this.jdField_a_of_type_JavaUtilArrayList.size();
        int m = this.jdField_a_of_type_JavaUtilArrayList.size();
        if ((m != this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
          throw new IllegalArgumentException("buttons size and custom ids size not match");
        }
        j = 0;
        if (j < m)
        {
          Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          Object localObject3;
          if (((Integer)localPair.second).intValue() == 65537)
          {
            localObject3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(b(), null);
            localObject2 = (TextView)((View)localObject3).findViewById(2131361969);
            localObject1 = (TextView)((View)localObject3).findViewById(2131378005);
            Object localObject4 = ((CharSequence)localPair.first).toString();
            int n = ((String)localObject4).indexOf('\n');
            if ((n >= 0) && (n < ((CharSequence)localPair.first).length()))
            {
              ((TextView)localObject2).setText(((String)localObject4).substring(0, n));
              ((TextView)localObject1).setText(((String)localObject4).substring(n + 1));
              ((View)localObject3).findViewById(2131364070).setContentDescription(((TextView)localObject2).getText());
              label408:
              localObject4 = (Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
              if (localObject4 != null) {
                ((TextView)localObject1).setTextColor(((Integer)localObject4).intValue());
              }
              bfpm.b(((View)localObject3).findViewById(2131364070), LinearLayout.class.getName());
              label452:
              if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
              {
                localObject1 = (bjnv)this.jdField_a_of_type_JavaUtilHashMap.get(localPair.first);
                if ((localObject1 != null) && (((bjnv)localObject1).jdField_b_of_type_Int != 0)) {
                  ((TextView)localObject2).setId(((bjnv)localObject1).jdField_b_of_type_Int);
                }
              }
              localObject1 = (ImageView)((View)localObject3).findViewById(2131361981);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F);
              ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(j))) {
                break label1089;
              }
              ((ImageView)localObject1).setVisibility(0);
              ((ImageView)localObject1).setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
              label593:
              localObject1 = (ImageView)((View)localObject3).findViewById(2131361982);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
              if ((this.jdField_d_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(j))) && (((Integer)this.jdField_d_of_type_JavaUtilHashMap.get(Integer.valueOf(j))).intValue() == 0))
              {
                ((RelativeLayout.LayoutParams)localObject4).width = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).height = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).addRule(15);
              }
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
              ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(j))) {
                break label1105;
              }
              ((ImageView)localObject1).setVisibility(0);
              ((ImageView)localObject1).setImageDrawable((Drawable)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
              label748:
              if (((Integer)localPair.second).intValue() != 9) {
                break label1121;
              }
              if (this.jdField_e_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(j))) {
                ((TextView)localObject2).setTextColor(Color.parseColor((String)this.jdField_e_of_type_JavaUtilHashMap.get(Integer.valueOf(j))));
              }
              label800:
              if ((!this.jdField_d_of_type_Boolean) || (k <= 1) || (j != m - 1) || (this.jdField_c_of_type_JavaLangCharSequence != null)) {
                break label1144;
              }
              localObject1 = a(4);
              label833:
              ((View)localObject3).setBackgroundDrawable((Drawable)localObject1);
              if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label1241;
              }
              ((View)localObject3).setId(((Integer)this.jdField_a_of_type_JavaUtilList.get(j)).intValue());
              label874:
              ((View)localObject3).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
              if (this.jdField_a_of_type_Boolean)
              {
                if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
                  this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
                }
                this.jdField_b_of_type_AndroidUtilSparseArray.append(j, localObject3);
                if (j != this.jdField_c_of_type_Int) {
                  break label1250;
                }
                ((View)localObject3).findViewById(2131361970).setVisibility(0);
                a((TextView)localObject2, true);
              }
            }
          }
          for (;;)
          {
            j += 1;
            break;
            ((TextView)localObject2).setText((CharSequence)localPair.first);
            break label408;
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558439, null);
            localObject2 = (TextView)((View)localObject1).findViewById(2131361969);
            ((TextView)localObject2).setText((CharSequence)localPair.first);
            bfpm.b((View)localObject2, Button.class.getName());
            if (((Integer)localPair.second).intValue() == 11)
            {
              a(localPair, (TextView)localObject2);
              localObject3 = localObject1;
              break label452;
            }
            if (((Integer)localPair.second).intValue() == 10) {
              b(localPair, (TextView)localObject2);
            }
            localObject3 = localObject1;
            break label452;
            label1089:
            ((ImageView)localObject1).setImageDrawable(null);
            ((ImageView)localObject1).setVisibility(8);
            break label593;
            label1105:
            ((ImageView)localObject1).setImageDrawable(null);
            ((ImageView)localObject1).setVisibility(8);
            break label748;
            label1121:
            ((TextView)localObject2).setTextColor(a(((Integer)localPair.second).intValue()));
            break label800;
            label1144:
            if ((j == 0) && (k == m) && (k == 1))
            {
              localObject1 = a(0);
              break label833;
            }
            if ((j == 0) && (k == m) && (k > 1))
            {
              if (this.h)
              {
                localObject1 = a(1);
                break label833;
              }
              localObject1 = a(3);
              break label833;
            }
            if ((j == m - 1) && (k > 1))
            {
              localObject1 = a(0);
              break label833;
            }
            localObject1 = a(3);
            break label833;
            label1241:
            ((View)localObject3).setId(j);
            break label874;
            label1250:
            a((TextView)localObject2, false);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(c(), null);
        if (this.jdField_a_of_type_Int != 0)
        {
          localObject2 = (Button)((View)localObject1).findViewById(2131361967);
          ((Button)localObject2).setVisibility(0);
          ((Button)localObject2).setText(this.jdField_a_of_type_Int);
          ((Button)localObject2).setTextColor(this.jdField_b_of_type_Int);
          ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
          if (this.jdField_c_of_type_AndroidViewView$OnClickListener != null) {
            ((Button)localObject2).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          }
        }
        localObject2 = (Button)((View)localObject1).findViewById(2131361968);
        ((Button)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject2).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  protected int a()
  {
    return 2131558440;
  }
  
  protected int a(int paramInt)
  {
    switch (0xFFFF & paramInt)
    {
    case 9: 
    case 10: 
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165204);
    case 5: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 6: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 7: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165200);
    case 8: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165739);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165206);
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837571);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837590);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837568);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837571);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837575);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public bjnv a(int paramInt)
  {
    return a(a(paramInt));
  }
  
  public bjnv a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (bjnv)this.jdField_a_of_type_JavaUtilHashMap.get(paramCharSequence);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidate();
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, @IdRes int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt3));
    a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    a(paramInt, paramCharSequence, 0);
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131361969);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(a(paramInt2));
          paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
          this.jdField_a_of_type_JavaUtilArrayList.set(paramInt1, paramCharSequence);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, localLayoutParams);
    }
  }
  
  public void a(bjnv parambjnv, int paramInt)
  {
    if (parambjnv == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(parambjnv.a, parambjnv);
    a(parambjnv.a, paramInt);
  }
  
  public void a(bjoe parambjoe)
  {
    this.jdField_a_of_type_Bjoe = parambjoe;
  }
  
  public void a(bjof parambjof)
  {
    this.jdField_a_of_type_Bjof = parambjof;
  }
  
  public void a(bjog parambjog)
  {
    this.jdField_a_of_type_Bjog = parambjog;
  }
  
  public void a(bjoi parambjoi)
  {
    this.jdField_a_of_type_Bjoi = parambjoi;
  }
  
  public void a(bjoj parambjoj)
  {
    this.jdField_a_of_type_Bjoj = parambjoj;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, @IdRes int paramInt2)
  {
    a(paramCharSequence, paramInt1, paramInt2, Integer.valueOf(this.jdField_a_of_type_AndroidContentResResources.getColor(2131165205)));
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, @IdRes int paramInt2, Integer paramInteger)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt2));
    a(paramCharSequence, paramInt1);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, paramInteger);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (TextUtils.isEmpty(paramString)) {
        paramInt = 0;
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramInt == 9) {
        this.jdField_e_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1), paramString);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    a(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label139:
      if (paramBoolean1) {
        this.jdField_c_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1), paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt1);
    if (localObject == null) {}
    do
    {
      return;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString + "icon");
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).setPadding(AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentResResources), 0);
      localSpannableStringBuilder.setSpan(localObject, paramString.length(), localSpannableStringBuilder.length(), 18);
      paramString = new Pair(localSpannableStringBuilder, Integer.valueOf(paramInt2));
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      if (localURLDrawable != null) {
        ThreadManagerV2.executeOnSubThread(new ActionSheet.10(this, localURLDrawable));
      }
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1))
      {
        localObject = new Pair(paramString1, Integer.valueOf(10));
        paramString2 = (String)localObject;
        if (localURLDrawable != null) {
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramString1.hashCode()), localURLDrawable);
        }
      }
      for (paramString2 = (String)localObject; !this.jdField_a_of_type_JavaUtilArrayList.contains(paramString2); paramString2 = new Pair(a(paramString1, localURLDrawable), Integer.valueOf(10)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected int b()
  {
    return 2131558441;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    f();
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt), 0);
  }
  
  public void b(View paramView)
  {
    this.f = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected int c()
  {
    return 2131558438;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_d_of_type_JavaUtilHashMap.clear();
    this.jdField_e_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
  }
  
  public void c(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void d()
  {
    this.jdField_c_of_type_Int = -1;
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {}
    for (;;)
    {
      return;
      int k = this.jdField_b_of_type_AndroidUtilSparseArray.size();
      int j = 0;
      while (j < k)
      {
        View localView = (View)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j);
        if (localView != null)
        {
          localView.findViewById(2131361970).setVisibility(8);
          a((TextView)localView.findViewById(2131361969), false);
        }
        j += 1;
      }
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_c_of_type_Int = paramInt;
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
        if (localView != null)
        {
          localView.findViewById(2131361970).setVisibility(0);
          a((TextView)localView.findViewById(2131361969), true);
        }
      }
    }
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0) != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(null);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bjoi != null) {
      this.jdField_a_of_type_Bjoi.ab_();
    }
    if (this.g)
    {
      this.g = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheet.7(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.i) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 847	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 852	achg:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 852	achg:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 852	achg:a	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	bjnw
    //   9	1	1	localException	Exception
    //   15	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public void e(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_d_of_type_Int = paramInt;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    super.show();
    f();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheet.6(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnw
 * JD-Core Version:    0.7.0.1
 */