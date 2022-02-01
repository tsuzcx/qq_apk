import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class bnzk
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b;
  private int c;
  private int d;
  
  public bnzk(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    if (!paramBoolean)
    {
      i = bnzg.a.q;
      this.jdField_a_of_type_Int = i;
      if (paramBoolean) {
        break label85;
      }
      i = bnzg.a.p;
      label32:
      this.b = i;
      if (paramBoolean) {
        break label95;
      }
      i = bnzg.b.q;
      label48:
      this.c = i;
      if (paramBoolean) {
        break label105;
      }
    }
    label85:
    label95:
    label105:
    for (int i = bnzg.b.p;; i = bnzg.d.p)
    {
      this.d = i;
      a(paramContext);
      return;
      i = bnzg.c.q;
      break;
      i = bnzg.c.p;
      break label32;
      i = bnzg.d.q;
      break label48;
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    int i;
    if (!paramBoolean2)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean1)
      {
        i = this.b;
        localTextView.setTextColor(i);
        if (!paramBoolean1) {
          break label101;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
      }
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label113;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(1.0F, 0.0F, 0.0F, 2131165354);
      return;
      i = this.jdField_a_of_type_Int;
      break;
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean1) {}
      for (i = this.d;; i = this.c)
      {
        localTextView.setTextColor(i);
        break;
      }
      label101:
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
    }
    label113:
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzk
 * JD-Core Version:    0.7.0.1
 */