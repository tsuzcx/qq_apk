import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;

public abstract class aqqu
  implements aqri
{
  public Context a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public FullPopData a;
  public FullPopVideoView a;
  private String a;
  public boolean a;
  public ImageView b;
  private String b;
  public boolean b;
  public ImageView c;
  private boolean c;
  public ImageView d;
  
  public aqqu(Context paramContext, FullPopData paramFullPopData, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData = paramFullPopData;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "205929";; str = "205927")
    {
      aqsp.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, str, this.jdField_c_of_type_Boolean);
      return;
    }
  }
  
  public void a(View... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 6)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramVarArgs[0]);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramVarArgs[1]);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramVarArgs[2]);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramVarArgs[3]);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramVarArgs[4]);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView = ((FullPopVideoView)paramVarArgs[5]);
    this.d = ((ImageView)paramVarArgs[6]);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOnClickListener(new aqqv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqu
 * JD-Core Version:    0.7.0.1
 */