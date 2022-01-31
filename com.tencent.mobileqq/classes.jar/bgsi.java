import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2;
import com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class bgsi
  extends Dialog
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgsn jdField_a_of_type_Bgsn;
  private bgso jdField_a_of_type_Bgso;
  private bgsp jdField_a_of_type_Bgsp;
  private bgsq jdField_a_of_type_Bgsq;
  private bgsr jdField_a_of_type_Bgsr;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList<Pair<CharSequence, Integer>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<CharSequence, bgsh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet;
  public boolean a;
  private int jdField_b_of_type_Int = 300;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bgsl(this);
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  protected boolean b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new bgsm(this);
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private HashMap<Integer, Drawable> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private HashMap<Integer, Integer> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_d_of_type_Boolean;
  private HashMap<Integer, String> jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  protected bgsi(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true);
  }
  
  @TargetApi(14)
  protected bgsi(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131755759);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (DisplayUtil.isImmersiveSupported)) {
      getWindow().addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    DisplayUtil.clearCoverForStatus(getWindow(), true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559333, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361910));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361918));
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_c_of_type_AndroidViewView$OnClickListener;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165776);
    case 5: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 6: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    case 7: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165772);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131165779);
  }
  
  public static bgsi a(Context paramContext)
  {
    paramContext = new bgsi(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755756);
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
      paramTextView.setContentDescription(getContext().getString(2131694331) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131694332) + paramTextView.getText());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559336, null);
      ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840810));
      ((View)localObject1).setOnClickListener(new bgsj(this));
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
        i = 0;
        if (i < k)
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559335, null);
          TextView localTextView = (TextView)((View)localObject2).findViewById(2131361915);
          localObject1 = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localTextView.setText((CharSequence)((Pair)localObject1).first);
          bgon.a(localTextView, Button.class.getName());
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
          {
            localObject3 = (bgsh)this.jdField_a_of_type_JavaUtilHashMap.get(((Pair)localObject1).first);
            if ((localObject3 != null) && (((bgsh)localObject3).jdField_a_of_type_Int != 0)) {
              localTextView.setId(((bgsh)localObject3).jdField_a_of_type_Int);
            }
          }
          Object localObject3 = (ImageView)((View)localObject2).findViewById(2131361926);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
          localLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F);
          ((ImageView)localObject3).setLayoutParams(localLayoutParams);
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)))
          {
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
            label415:
            localObject3 = (ImageView)((View)localObject2).findViewById(2131361927);
            localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
            if ((this.jdField_d_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) && (((Integer)this.jdField_d_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).intValue() == 0))
            {
              localLayoutParams.width = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localLayoutParams.height = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localLayoutParams.addRule(15);
            }
            localLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
            ((ImageView)localObject3).setLayoutParams(localLayoutParams);
            if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
              break label771;
            }
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
            label570:
            if (((Integer)((Pair)localObject1).second).intValue() != 9) {
              break label787;
            }
            if (this.jdField_e_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
              localTextView.setTextColor(Color.parseColor((String)this.jdField_e_of_type_JavaUtilHashMap.get(Integer.valueOf(i))));
            }
            label622:
            if ((!this.jdField_b_of_type_Boolean) || (j <= 1) || (i != k - 1) || (this.jdField_c_of_type_JavaLangCharSequence != null)) {
              break label810;
            }
            localObject1 = a(4);
            label655:
            ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
            ((View)localObject2).setId(i);
            ((View)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            if (this.jdField_c_of_type_Boolean)
            {
              if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
                this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localObject2);
              if (i != this.jdField_a_of_type_Int) {
                break label890;
              }
              ((View)localObject2).findViewById(2131361916).setVisibility(0);
              a(localTextView, true);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label415;
            label771:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label570;
            label787:
            localTextView.setTextColor(a(((Integer)((Pair)localObject1).second).intValue()));
            break label622;
            label810:
            if ((i == 0) && (j == k) && (j == 1))
            {
              localObject1 = a(0);
              break label655;
            }
            if ((i == 0) && (j == k) && (j > 1))
            {
              localObject1 = a(3);
              break label655;
            }
            if ((i == k - 1) && (j > 1))
            {
              localObject1 = a(0);
              break label655;
            }
            localObject1 = a(3);
            break label655;
            label890:
            a(localTextView, false);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559334, null);
        localObject2 = (Button)((View)localObject1).findViewById(2131361914);
        ((Button)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject2).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840809);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840806);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840809);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840813);
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 466	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	bgsi
    //   5	2	1	localObject	Object
    //   8	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public void a(bgsn parambgsn)
  {
    this.jdField_a_of_type_Bgsn = parambgsn;
  }
  
  public void a(bgsp parambgsp)
  {
    this.jdField_a_of_type_Bgsp = parambgsp;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
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
      if (this.jdField_c_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
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
      if (this.jdField_c_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0) != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(null);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bgsq != null) {
      this.jdField_a_of_type_Bgsq.a();
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
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_d_of_type_Boolean) {}
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
    b();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheet.2(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsi
 * JD-Core Version:    0.7.0.1
 */