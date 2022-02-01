import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class ameg
  extends afwn
{
  public CheckBox a;
  public PhoneContact a;
  public boolean a;
  public View b;
  public TextView c;
  public TextView d;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("0".equals(paramString)) {
      return 11;
    }
    return 1;
  }
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new ameg();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376813));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379901));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364511));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368212));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379892));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131379974));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371647));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365586);
    return paramViewGroup;
  }
  
  public static void a(amnl paramamnl, ameg paramameg, PhoneContact paramPhoneContact)
  {
    paramameg.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramameg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramameg.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramameg.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramameg.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842062);
      paramameg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramameg.jdField_c_of_type_AndroidWidgetTextView.setText(bhlg.a(paramPhoneContact.name));
      paramameg.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramameg.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramameg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramamnl.a(paramameg.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramameg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramameg.jdField_a_of_type_Boolean = false;
      return;
    }
    paramameg.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramameg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramamnl.a(paramameg.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramameg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramameg.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameg
 * JD-Core Version:    0.7.0.1
 */