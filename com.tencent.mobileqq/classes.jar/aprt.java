import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class aprt
  extends apru
  implements View.OnClickListener
{
  protected int f;
  
  public aprt(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, appt paramappt, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296845));
  }
  
  public View a(apow paramapow, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Aprv = ((aprv)paramapow);
    if (paramView == null)
    {
      paramapow = apsr.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramapow == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramapow = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561686, null);
        paramapow.setLayoutParams(paramView);
        this.jdField_a_of_type_Aprv.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramapow.findViewById(2131364879));
        this.jdField_a_of_type_Aprv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramapow.findViewById(2131364970));
        this.jdField_a_of_type_Aprv.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramapow.findViewById(2131364968));
        a(this.c, paramapow);
        paramapow.setTag(this.jdField_a_of_type_Aprv);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Aprv);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296845);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramapow.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramapow.setLayoutParams(paramView);
        }
      }
      return paramapow;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramapow = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprt
 * JD-Core Version:    0.7.0.1
 */