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
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.widget.ActionSheet.2;
import com.tencent.widget.ActionSheet.3;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class bhuf
  extends Dialog
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Resources a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhuk jdField_a_of_type_Bhuk;
  private bhul jdField_a_of_type_Bhul;
  private bhum jdField_a_of_type_Bhum;
  private bhun jdField_a_of_type_Bhun;
  private bhuo jdField_a_of_type_Bhuo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public Object a;
  private ArrayList<Pair<CharSequence, Integer>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<CharSequence, bhue> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public boolean c;
  private int jdField_d_of_type_Int = 300;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new bhui(this);
  private HashMap<Integer, Integer> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  protected boolean d;
  private HashMap<Integer, String> jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  protected bhuf(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected bhuf(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true, -1, null);
  }
  
  @TargetApi(14)
  protected bhuf(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramContext, 2131755225);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bhuj(this);
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
        break label337;
      }
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup, paramLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361910));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361918));
      this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      return;
      paramInt = 2131558431;
      break;
      label337:
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public static bhuf a(Context paramContext)
  {
    paramContext = new bhuf(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static bhuf a(Context paramContext, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = new bhuf(paramContext, false, false, true, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static bhuf a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new bhuf(paramContext, false, true, paramBoolean, -1, null);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(2131691174) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131691176) + paramTextView.getText());
  }
  
  public static bhuf b(Context paramContext)
  {
    paramContext = new bhuf(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static bhuf c(Context paramContext)
  {
    paramContext = new bhuf(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static bhuf d(Context paramContext)
  {
    paramContext = new bhuf(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
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
      ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837560));
      ((View)localObject1).setOnClickListener(new bhug(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131361928));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131361925);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject2).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0);
    }
    for (int i = 1;; i = 0)
    {
      if (this.f) {
        i = 1;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int j = i + this.jdField_a_of_type_JavaUtilArrayList.size();
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        if ((k != this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
          throw new IllegalArgumentException("buttons size and custom ids size not match");
        }
        i = 0;
        if (i < k)
        {
          localObject1 = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          View localView;
          Object localObject3;
          if (((Integer)((Pair)localObject1).second).intValue() == 65537)
          {
            localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(b(), null);
            localObject2 = (TextView)localView.findViewById(2131361915);
            localObject3 = (TextView)localView.findViewById(2131377267);
            Object localObject4 = ((CharSequence)((Pair)localObject1).first).toString();
            int m = ((String)localObject4).indexOf('\n');
            if ((m >= 0) && (m < ((CharSequence)((Pair)localObject1).first).length()))
            {
              ((TextView)localObject2).setText(((String)localObject4).substring(0, m));
              ((TextView)localObject3).setText(((String)localObject4).substring(m + 1));
              localView.findViewById(2131363815).setContentDescription(((TextView)localObject2).getText());
              label408:
              bczz.b(localView.findViewById(2131363815), LinearLayout.class.getName());
              label424:
              if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
              {
                localObject3 = (bhue)this.jdField_a_of_type_JavaUtilHashMap.get(((Pair)localObject1).first);
                if ((localObject3 != null) && (((bhue)localObject3).jdField_b_of_type_Int != 0)) {
                  ((TextView)localObject2).setId(((bhue)localObject3).jdField_b_of_type_Int);
                }
              }
              localObject3 = (ImageView)localView.findViewById(2131361926);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
              ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
                break label1002;
              }
              ((ImageView)localObject3).setVisibility(0);
              ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
              label565:
              localObject3 = (ImageView)localView.findViewById(2131361927);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
              if ((this.jdField_d_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) && (((Integer)this.jdField_d_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).intValue() == 0))
              {
                ((RelativeLayout.LayoutParams)localObject4).width = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).height = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).addRule(15);
              }
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
              ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
                break label1018;
              }
              ((ImageView)localObject3).setVisibility(0);
              ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
              label720:
              if (((Integer)((Pair)localObject1).second).intValue() != 9) {
                break label1034;
              }
              if (this.jdField_e_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
                ((TextView)localObject2).setTextColor(Color.parseColor((String)this.jdField_e_of_type_JavaUtilHashMap.get(Integer.valueOf(i))));
              }
              label772:
              if ((!this.jdField_d_of_type_Boolean) || (j <= 1) || (i != k - 1) || (this.jdField_c_of_type_JavaLangCharSequence != null)) {
                break label1057;
              }
              localObject1 = a(4);
              label805:
              localView.setBackgroundDrawable((Drawable)localObject1);
              if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label1137;
              }
              localView.setId(((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue());
              label846:
              localView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
              if (this.jdField_a_of_type_Boolean)
              {
                if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
                  this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
                }
                this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localView);
                if (i != this.jdField_c_of_type_Int) {
                  break label1146;
                }
                localView.findViewById(2131361916).setVisibility(0);
                a((TextView)localObject2, true);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
            break label408;
            localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558434, null);
            localObject2 = (TextView)localView.findViewById(2131361915);
            ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
            bczz.b((View)localObject2, Button.class.getName());
            break label424;
            label1002:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label565;
            label1018:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label720;
            label1034:
            ((TextView)localObject2).setTextColor(a(((Integer)((Pair)localObject1).second).intValue()));
            break label772;
            label1057:
            if ((i == 0) && (j == k) && (j == 1))
            {
              localObject1 = a(0);
              break label805;
            }
            if ((i == 0) && (j == k) && (j > 1))
            {
              localObject1 = a(3);
              break label805;
            }
            if ((i == k - 1) && (j > 1))
            {
              localObject1 = a(0);
              break label805;
            }
            localObject1 = a(3);
            break label805;
            label1137:
            localView.setId(i);
            break label846;
            label1146:
            a((TextView)localObject2, false);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(c(), null);
        if (this.jdField_a_of_type_Int != 0)
        {
          localObject2 = (Button)((View)localObject1).findViewById(2131361913);
          ((Button)localObject2).setVisibility(0);
          ((Button)localObject2).setText(this.jdField_a_of_type_Int);
          ((Button)localObject2).setTextColor(this.jdField_b_of_type_Int);
          ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
          if (this.jdField_c_of_type_AndroidViewView$OnClickListener != null) {
            ((Button)localObject2).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          }
        }
        localObject2 = (Button)((View)localObject1).findViewById(2131361914);
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
    return 2131558435;
  }
  
  protected int a(int paramInt)
  {
    switch (0xFFFF & paramInt)
    {
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
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165691);
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837559);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837556);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837559);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837563);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public bhue a(int paramInt)
  {
    return a(a(paramInt));
  }
  
  public bhue a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (bhue)this.jdField_a_of_type_JavaUtilHashMap.get(paramCharSequence);
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
        localObject = ((View)localObject).findViewById(2131361915);
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
  
  public void a(bhue parambhue, int paramInt)
  {
    if (parambhue == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(parambhue.a, parambhue);
    a(parambhue.a, paramInt);
  }
  
  public void a(bhuk parambhuk)
  {
    this.jdField_a_of_type_Bhuk = parambhuk;
  }
  
  public void a(bhul parambhul)
  {
    this.jdField_a_of_type_Bhul = parambhul;
  }
  
  public void a(bhum parambhum)
  {
    this.jdField_a_of_type_Bhum = parambhum;
  }
  
  public void a(bhun parambhun)
  {
    this.jdField_a_of_type_Bhun = parambhun;
  }
  
  public void a(bhuo parambhuo)
  {
    this.jdField_a_of_type_Bhuo = parambhuo;
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
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt2));
    a(paramCharSequence, paramInt1);
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
      ((VerticalCenterImageSpan)localObject).setPadding(aepi.a(10.0F, this.jdField_a_of_type_AndroidContentResResources), 0);
      localSpannableStringBuilder.setSpan(localObject, paramString.length(), localSpannableStringBuilder.length(), 18);
      paramString = new Pair(localSpannableStringBuilder, Integer.valueOf(paramInt2));
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected int b()
  {
    return 2131558436;
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
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  protected int c()
  {
    return 2131558433;
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
  
  public void d()
  {
    this.jdField_c_of_type_Int = -1;
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if (localView != null)
        {
          localView.findViewById(2131361916).setVisibility(8);
          a((TextView)localView.findViewById(2131361915), false);
        }
        i += 1;
      }
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_c_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
        if (localView != null)
        {
          localView.findViewById(2131361916).setVisibility(0);
          a((TextView)localView.findViewById(2131361915), true);
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
    this.h = paramBoolean;
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bhun != null) {
      this.jdField_a_of_type_Bhun.ap_();
    }
    if (this.g)
    {
      this.g = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheet.3(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.h) && (paramAccessibilityEvent.getEventType() == 32)) {
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
    //   1: invokespecial 707	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 712	abvb:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 712	abvb:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 712	abvb:a	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	bhuf
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheet.2(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhuf
 * JD-Core Version:    0.7.0.1
 */