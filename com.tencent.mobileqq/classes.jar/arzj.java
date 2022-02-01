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

public class arzj
  extends arzk
  implements View.OnClickListener
{
  protected int f;
  
  public arzj(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, arxd paramarxd, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296895));
  }
  
  public View a(arwg paramarwg, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Arzl = ((arzl)paramarwg);
    if (paramView == null)
    {
      paramarwg = asak.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramarwg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramarwg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561940, null);
        paramarwg.setLayoutParams(paramView);
        this.jdField_a_of_type_Arzl.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramarwg.findViewById(2131365114));
        this.jdField_a_of_type_Arzl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramarwg.findViewById(2131365208));
        this.jdField_a_of_type_Arzl.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramarwg.findViewById(2131365206));
        a(this.c, paramarwg);
        paramarwg.setTag(this.jdField_a_of_type_Arzl);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Arzl);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296895);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramarwg.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramarwg.setLayoutParams(paramView);
        }
      }
      return paramarwg;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramarwg = paramView;
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
 * Qualified Name:     arzj
 * JD-Core Version:    0.7.0.1
 */