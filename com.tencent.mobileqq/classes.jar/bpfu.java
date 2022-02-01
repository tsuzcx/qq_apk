import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class bpfu
  extends ReportDialog
{
  float jdField_a_of_type_Float = 1.0F;
  private final int jdField_a_of_type_Int = getContext().getResources().getColor(2131165343);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bpfw jdField_a_of_type_Bpfw;
  HashMap<Float, TextView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int jdField_b_of_type_Int = getContext().getResources().getColor(2131165477);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = bqrh.b(getContext(), 212.0F);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = bqrh.b(getContext(), 12.0F);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int = 85;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  
  public bpfu(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755189);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558569, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380187));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380092));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380096));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380016));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380186));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bpfv(this, 0.5F));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bpfv(this, 0.75F));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new bpfv(this, 1.0F));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new bpfv(this, 1.5F));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new bpfv(this, 2.0F));
    this.jdField_a_of_type_JavaUtilHashMap.put(Float.valueOf(0.5F), this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilHashMap.put(Float.valueOf(0.75F), this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilHashMap.put(Float.valueOf(1.0F), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilHashMap.put(Float.valueOf(1.5F), this.jdField_d_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilHashMap.put(Float.valueOf(2.0F), this.jdField_e_of_type_AndroidWidgetTextView);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        boolean bool = ((Float)((Map.Entry)localObject).getKey()).equals(Float.valueOf(this.jdField_a_of_type_Float));
        ((TextView)((Map.Entry)localObject).getValue()).setSelected(bool);
        localObject = (TextView)((Map.Entry)localObject).getValue();
        if (bool) {}
        for (int i = this.jdField_b_of_type_Int;; i = this.jdField_a_of_type_Int)
        {
          ((TextView)localObject).setTextColor(i);
          break;
        }
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(bpfw parambpfw)
  {
    this.jdField_a_of_type_Bpfw = parambpfw;
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void show()
  {
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    super.show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(this.jdField_e_of_type_Int);
    localLayoutParams.y = this.jdField_c_of_type_Int;
    localLayoutParams.x = this.jdField_d_of_type_Int;
    localLayoutParams.dimAmount = 0.1F;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setLayout(bqrh.b(getContext(), 65.0F), -2);
    localWindow.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfu
 * JD-Core Version:    0.7.0.1
 */