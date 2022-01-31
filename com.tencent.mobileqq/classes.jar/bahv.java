import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bahv
{
  public int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  public LinearLayout a;
  protected TextView a;
  protected baib a;
  protected final begr a;
  public ElasticHorScrView a;
  protected CharSequence a;
  private String a;
  protected boolean a;
  protected List<bahx>[] a;
  public int b;
  protected GridView b;
  public TextView b;
  public ElasticHorScrView b;
  protected boolean b;
  protected int c;
  private boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public bahv(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public bahv(Context paramContext, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.b(this.jdField_a_of_type_AndroidContentContext, null));
      paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(2131165597);
      this.e = this.jdField_c_of_type_Int;
      this.f = paramContext.getDimensionPixelOffset(2131165599);
      this.g = paramContext.getDimensionPixelOffset(2131165600);
      this.jdField_a_of_type_Baib = new baib();
      i = paramContext.getDisplayMetrics().widthPixels;
      int j = paramContext.getDisplayMetrics().heightPixels;
      if (i <= j) {
        break label173;
      }
      i = j;
    }
    label173:
    for (;;)
    {
      i = (i - (int)(a() * 5.2F)) / (((int)5.2F + 1) * 2);
      c(i);
      b((int)(i * 6 / 5.5F));
      return;
      this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null));
      break;
    }
  }
  
  private static int a(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    int j;
    if (paramTextPaint.measureText(paramString) < paramFloat)
    {
      j = paramString.length();
      return j;
    }
    int i = 1;
    for (;;)
    {
      if (i > paramString.length()) {
        break label54;
      }
      j = i;
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        break;
      }
      i += 1;
    }
    label54:
    return paramString.length();
  }
  
  protected static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = a(paramTextPaint, paramString, paramFloat);
        if (!ajlo.a()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = a(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt) {
        paramTextPaint = paramString.substring(0, paramInt) + "..";
      }
      return str + "\n" + paramTextPaint;
    } while (paramString.length() <= i);
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int j = paramString.length;
    paramInt = 0;
    for (;;)
    {
      int k;
      if (paramInt < j)
      {
        str = paramString[paramInt];
        k = paramTextPaint.toString().length() + str.length();
        if (k <= i * 2) {}
      }
      else
      {
        paramString = paramTextPaint.toString().trim();
        paramTextPaint = paramString;
        if (paramString.length() > i * 2) {
          paramTextPaint = paramString.substring(0, i) + "..";
        }
        return paramTextPaint;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (k > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str).append(" ");
      paramInt += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131493269, null);
    this.jdField_a_of_type_Baib.a((RelativeLayout)localView.findViewById(2131296596));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131296385));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296383));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131309901));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131309902));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label404;
      }
      localObject1 = localObject2[0];
      label136:
      if (!((List)localObject1).isEmpty()) {
        break label967;
      }
    }
    label161:
    label956:
    label959:
    label962:
    label967:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label962;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167716));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject1), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject2), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131165596);
        int i;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131301556));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label364:
          if (((Iterator)localObject4).hasNext())
          {
            if (((bahx)((Iterator)localObject4).next()).d != 0) {
              break label959;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label364;
          e();
          break;
          localObject1 = new ArrayList(0);
          break label136;
          localObject2 = new ArrayList(0);
          break label161;
          int n = this.d + a() + this.d;
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(n);
          this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
          localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.h + this.h);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
          this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131301557));
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((bahx)((Iterator)localObject1).next()).d != 0) {
                break label956;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.d + a() + this.d;
            this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(n);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
            this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.h + this.h);
            this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
            this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
            this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296376));
            this.jdField_b_of_type_AndroidWidgetTextView.setText(2131627266);
            this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bahw(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new ShareActionSheetBuilder.2(this));
            return localView;
          }
        }
      }
    }
  }
  
  public View a(int paramInt)
  {
    Window localWindow = this.jdField_a_of_type_Begr.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public Window a()
  {
    return this.jdField_a_of_type_Begr.getWindow();
  }
  
  protected bahy a(Context paramContext, List<bahx> paramList)
  {
    return new bahy(paramContext, paramList);
  }
  
  public begr a()
  {
    return this.jdField_a_of_type_Begr;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<bahx> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bahx)paramList.get(i)).jdField_a_of_type_JavaLangString;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!a())
      {
        if (this.jdField_c_of_type_Boolean) {
          wed.b(a());
        }
        this.jdField_a_of_type_Begr.show();
        if (this.jdField_c_of_type_Boolean)
        {
          wed.a(a());
          wed.c(a());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_Begr.setOnCancelListener(paramOnCancelListener);
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_Begr != null) {
      this.jdField_a_of_type_Begr.setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_a_of_type_Begr.setOnShowListener(paramOnShowListener);
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_Baib.a(paramView, paramLayoutParams);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_Boolean = true;
    if (paramOnItemClickListener == null)
    {
      if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
      }
      if (this.jdField_b_of_type_AndroidWidgetGridView != null) {
        this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<bahx>[] paramArrayOfList)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Begr.isShowing();
  }
  
  protected List<bahx>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    a(null);
    if (a()) {}
    try
    {
      this.jdField_a_of_type_Begr.dismiss();
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Begr.isShowing())
    {
      this.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_AndroidViewView, null);
    }
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Begr.isShowing())
    {
      this.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_AndroidViewView, null);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Baib.a(paramInt);
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.h;
    } while ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null) || (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView == null));
    if (i < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (i < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahv
 * JD-Core Version:    0.7.0.1
 */