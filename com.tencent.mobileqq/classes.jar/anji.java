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

public class anji
  extends anjj
  implements View.OnClickListener
{
  protected int f;
  
  public anji(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anhs paramanhs, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131165754));
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Anjk = ((anjk)paramangv);
    if (paramView == null)
    {
      paramangv = ankg.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramangv == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramangv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495904, null);
        paramangv.setLayoutParams(paramView);
        this.jdField_a_of_type_Anjk.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramangv.findViewById(2131299236));
        this.jdField_a_of_type_Anjk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramangv.findViewById(2131299320));
        this.jdField_a_of_type_Anjk.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramangv.findViewById(2131299318));
        a(this.c, paramangv);
        paramangv.setTag(this.jdField_a_of_type_Anjk);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Anjk);
      return paramangv;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramangv = paramView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anji
 * JD-Core Version:    0.7.0.1
 */