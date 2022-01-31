import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
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

public class bbjq
  implements bcvf
{
  public int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  public LinearLayout a;
  protected TextView a;
  protected bbjw a;
  private bcvf jdField_a_of_type_Bcvf;
  protected bfpc a;
  public ElasticHorScrView a;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  protected List<bbjs>[] a;
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
  
  public bbjq(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public bbjq(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, 1);
  }
  
  public bbjq(Context paramContext, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramInt == 2)
    {
      bcvv localbcvv = new bcvv();
      localbcvv.jdField_a_of_type_AndroidContentContext = paramContext;
      localbcvv.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Bcvf = bcvh.a(localbcvv);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.b(this.jdField_a_of_type_AndroidContentContext, null));
      paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(2131296669);
      this.e = this.jdField_c_of_type_Int;
      this.f = paramContext.getDimensionPixelOffset(2131296671);
      this.g = paramContext.getDimensionPixelOffset(2131296672);
      this.jdField_a_of_type_Bbjw = new bbjw();
      paramInt = paramContext.getDisplayMetrics().widthPixels;
      int i = paramContext.getDisplayMetrics().heightPixels;
      if (paramInt <= i) {
        break label209;
      }
      paramInt = i;
    }
    label209:
    for (;;)
    {
      paramInt = (paramInt - (int)(a() * 5.2F)) / (((int)5.2F + 1) * 2);
      c(paramInt);
      b((int)(paramInt * 6 / 5.5F));
      return;
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null));
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
        if (!ajzt.a()) {
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
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a();
    }
    return this.jdField_c_of_type_Int;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558829, null);
    this.jdField_a_of_type_Bbjw.a((RelativeLayout)localView.findViewById(2131362136));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361920));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361918));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375664));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375665));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label406;
      }
      localObject1 = localObject2[0];
      label136:
      if (!((List)localObject1).isEmpty()) {
        break label969;
      }
    }
    label161:
    label958:
    label961:
    label964:
    label969:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label964;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298815));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject1), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject2), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296668);
        int i;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367168));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label366:
          if (((Iterator)localObject4).hasNext())
          {
            if (((bbjs)((Iterator)localObject4).next()).d != 0) {
              break label961;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label366;
          f();
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
            this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367169));
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((bbjs)((Iterator)localObject1).next()).d != 0) {
                break label958;
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
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361911));
            this.jdField_b_of_type_AndroidWidgetTextView.setText(2131692905);
            this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bbjr(this));
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
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a(paramInt);
    }
    Window localWindow = this.jdField_a_of_type_Bfpc.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public Window a()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a();
    }
    return this.jdField_a_of_type_Bfpc.getWindow();
  }
  
  protected bbjt a(Context paramContext, List<bbjs> paramList)
  {
    return new bbjt(paramContext, paramList);
  }
  
  public bfpc a()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a();
    }
    return this.jdField_a_of_type_Bfpc;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<bbjs> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bbjs)paramList.get(i)).jdField_a_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a();
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidViewView = a();
        }
        this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_AndroidViewView, null);
        try
        {
          if (!a())
          {
            if (this.jdField_c_of_type_Boolean) {
              wsr.b(a());
            }
            this.jdField_a_of_type_Bfpc.show();
            if (this.jdField_c_of_type_Boolean)
            {
              wsr.a(a());
              wsr.c(a());
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramOnCancelListener);
      return;
    }
    this.jdField_a_of_type_Bfpc.setOnCancelListener(paramOnCancelListener);
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(paramOnDismissListener);
    }
    while (this.jdField_a_of_type_Bfpc == null) {
      return;
    }
    this.jdField_a_of_type_Bfpc.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramOnShowListener);
      return;
    }
    this.jdField_a_of_type_Bfpc.setOnShowListener(paramOnShowListener);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(paramIntent);
    }
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramView, paramLayoutParams);
      return;
    }
    this.jdField_a_of_type_Bbjw.a(paramView, paramLayoutParams);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(paramOnItemClickListener);
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
        this.jdField_a_of_type_Boolean = true;
      } while (paramOnItemClickListener != null);
      if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
      }
    } while (this.jdField_b_of_type_AndroidWidgetGridView == null);
    this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
  }
  
  public void a(bcvg parambcvg)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(parambcvg);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.a(paramCharSequence);
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramString);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<bbjs> paramList1, List<bbjs> paramList2) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramBoolean);
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<bbjs>[] paramArrayOfList)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.a(paramArrayOfList);
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      return this.jdField_a_of_type_Bcvf.a();
    }
    return this.jdField_a_of_type_Bfpc.isShowing();
  }
  
  protected List<bbjs>[] a()
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
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.b();
    }
    do
    {
      return;
      a(null);
    } while (!a());
    try
    {
      this.jdField_a_of_type_Bfpc.dismiss();
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
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.b(paramInt);
      return;
    }
    this.h = paramInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.c();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.c(paramInt);
      return;
    }
    this.d = paramInt;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.d();
    }
    while (!this.jdField_a_of_type_Bfpc.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_AndroidViewView, null);
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bcvf != null)
    {
      this.jdField_a_of_type_Bcvf.d(paramInt);
      return;
    }
    this.jdField_a_of_type_Bbjw.a(paramInt);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.e();
    }
    while (!this.jdField_a_of_type_Bfpc.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_AndroidViewView, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.f();
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bcvf != null) {
      this.jdField_a_of_type_Bcvf.g();
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
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
 * Qualified Name:     bbjq
 * JD-Core Version:    0.7.0.1
 */