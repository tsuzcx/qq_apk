import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.togetherui.writetogether.SavingAnimView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class bdkh
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SavingAnimView jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public bdkh(Context paramContext, View paramView, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.e = paramTextView;
    a(paramView);
    k();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381230));
    this.b = ((TextView)paramView.findViewById(2131381232));
    this.c = ((TextView)paramView.findViewById(2131381234));
    this.d = ((TextView)paramView.findViewById(2131381231));
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView = ((SavingAnimView)paramView.findViewById(2131381235));
    paramView = paramView.getParent();
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (RelativeLayout)paramView;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      paramView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView.setOnAnimationStateListener(new bdki(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int j = 0;
    Object localObject = this.d;
    if (paramBoolean1)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView;
      if (!paramBoolean2) {
        break label135;
      }
      i = 0;
      label36:
      ((SavingAnimView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean3) {
        break label142;
      }
      i = 0;
      label56:
      ((TextView)localObject).setVisibility(i);
      localObject = this.b;
      if (!paramBoolean4) {
        break label149;
      }
      i = 0;
      label77:
      ((TextView)localObject).setVisibility(i);
      localObject = this.c;
      if (!paramBoolean5) {
        break label156;
      }
      i = 0;
      label98:
      ((TextView)localObject).setVisibility(i);
      localObject = this.e;
      if (!paramBoolean6) {
        break label163;
      }
    }
    label135:
    label142:
    label149:
    label156:
    label163:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label36;
      i = 8;
      break label56;
      i = 8;
      break label77;
      i = 8;
      break label98;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    a(false, false, true, false, false, paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramBoolean, false, true, paramBoolean, true);
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Int = DisplayUtil.getScreenSize(this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_Int;
  }
  
  private void l()
  {
    float f = this.b.getTextSize();
    this.b.setTranslationY(f);
    this.c.animate().alpha(0.0F).translationY(-f).setDuration(500L).start();
    this.b.animate().alpha(1.0F).translationYBy(-f).setDuration(500L).setStartDelay(100L).setListener(new bdkj(this)).start();
  }
  
  private void m()
  {
    float f = this.b.getTextSize();
    this.b.animate().setListener(null);
    this.b.setAlpha(1.0F);
    this.b.animate().alpha(0.0F).translationY(-f).setDuration(500L).start();
    this.c.setTranslationY(f);
    this.c.animate().alpha(1.0F).translationYBy(-f).setDuration(500L).setStartDelay(100L).start();
  }
  
  private void n()
  {
    a(false, false, true, false, false, false);
  }
  
  private void o()
  {
    a(false, true, false, true, true, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299205);
  }
  
  public TextPaint a()
  {
    return this.b.getPaint();
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitting]");
    }
    o();
  }
  
  public void a(String paramString)
  {
    this.e.setText(paramString);
    if (this.e.getCompoundDrawables()[3] == null)
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
      Drawable localDrawable = paramString.getDrawable(2130850349);
      int i = paramString.getDimensionPixelSize(2131299213);
      localDrawable.setBounds(0, 0, i, i);
      this.e.setCompoundDrawables(null, null, localDrawable, null);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      this.b.setText(paramString);
      this.b.getParent().requestLayout();
      this.d.setVisibility(8);
      return;
    }
    this.d.setText(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(false, false, true, false, false, paramBoolean);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719424);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = this.jdField_a_of_type_Int - localResources.getDimensionPixelSize(2131299210) * 2 - localResources.getDimensionPixelSize(2131299212);
    int j = localResources.getDimensionPixelSize(2131299211);
    if (i < j) {
      return j;
    }
    return i;
  }
  
  public TextPaint b()
  {
    return this.e.getPaint();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitted]");
    }
    j();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299206) * 2;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[startAnimation]");
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView.a();
    m();
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299204);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[stopAnimation]");
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherSavingAnimView.b();
  }
  
  public void e()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719440);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public void f()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719441);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public void g()
  {
    n();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719425);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public void h()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719716);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009));
  }
  
  public void i()
  {
    c(false);
  }
  
  public void j()
  {
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkh
 * JD-Core Version:    0.7.0.1
 */