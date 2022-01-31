import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;

public class azby
  extends azbz
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130843117, 2130843116, 2130843115 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ajjy.a(2131647451), ajjy.a(2131647450), ajjy.a(2131647452) };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "http://p.qpic.cn/qqconadmin/0/7af9600e477b4f868fbaa01c879ab2bc/0", "http://p.qpic.cn/qqconadmin/0/a5c9695d3d0c4958b20b505cccf02c55/0", "http://p.qpic.cn/qqconadmin/0/a9fbe3f96d294504811d5c4dc802d02b/0" };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  protected azby(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312486));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131303684);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312331));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312495));
    this.d = ((TextView)paramView.findViewById(2131312276));
    this.e = ((TextView)paramView.findViewById(2131312485));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302876));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303041));
    this.f = ((TextView)paramView.findViewById(2131312484));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300000));
    paramView.setLayerType(1, null);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.e.setVisibility(0);
    ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
  }
  
  public void a()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    localAnimationDrawable.stop();
    localAnimationDrawable.selectDrawable(0);
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, azbx paramazbx)
  {
    paramazbx = (azac)paramazbx.a;
    switch (paramView.getId())
    {
    default: 
    case 2131303684: 
      do
      {
        return;
        if (paramazbx.jdField_a_of_type_Boolean)
        {
          paramHWReciteItem.b();
          a();
          return;
        }
      } while (TextUtils.isEmpty(paramazbx.jdField_d_of_type_JavaLangString));
      if (QLog.isColorLevel()) {
        QLog.d("ReciteResultSubViewHolder", 2, new Object[] { "onItemViewClick, play audio, filePath = ", paramazbx.jdField_d_of_type_JavaLangString });
      }
      paramHWReciteItem.e(paramazbx);
      b();
      azzx.a("Grp_edu", "Grp_recite", "Finish_Recite_Play_Clk", 0, 0, new String[] { paramazbx.jdField_f_of_type_JavaLangString });
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHWReciteItem.b(paramazbx);
  }
  
  public void a(HWReciteItem paramHWReciteItem, azbx paramazbx, azac paramazac, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = paramazac.jdField_b_of_type_JavaLangString;
    String str = ReciteFragment.a((String)localObject);
    if (str.length() > 8) {
      localObject = "《" + str.substring(0, 8) + "…";
    }
    localObject = new StringBuilder(ajjy.a(2131647454)).append((String)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramazac.jdField_d_of_type_Int));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(paramazac.jdField_e_of_type_Int));
    this.e.setText(String.format("%s\"", new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(paramazac.jdField_a_of_type_Long) }));
    paramInt = paramazac.jdField_f_of_type_Int - 1;
    if ((paramInt > -1) && (paramInt < jdField_a_of_type_ArrayOfInt.length))
    {
      this.d.setText(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      this.f.setText(ayxq.jdField_a_of_type_ArrayOfJavaLangString[paramInt].replace("\n", ""));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = azvv.a(BaseApplicationImpl.getContext(), 120.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = azvv.a(BaseApplicationImpl.getContext(), 120.0F);
      localObject = URLDrawable.getDrawable(jdField_b_of_type_ArrayOfJavaLangString[paramInt], (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if ((!TextUtils.isEmpty(paramazac.jdField_d_of_type_JavaLangString)) && (new File(paramazac.jdField_d_of_type_JavaLangString).exists()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.e.setVisibility(0);
      if (!paramazac.jdField_a_of_type_Boolean) {
        break label417;
      }
      b();
      label315:
      if (paramazac.g != 2) {
        break label424;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramHWReciteItem.b(this.jdField_b_of_type_AndroidViewView, paramazbx);
      paramHWReciteItem.b(this.jdField_b_of_type_AndroidWidgetImageView, paramazbx);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.e.setVisibility(8);
      if ((TextUtils.isEmpty(paramazac.jdField_e_of_type_JavaLangString)) || (paramazac.jdField_b_of_type_Int != 0)) {
        break;
      }
      paramHWReciteItem.d(paramazac);
      if (paramazac.jdField_b_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.e.setVisibility(0);
      break;
      label417:
      a();
      break label315;
      label424:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azby
 * JD-Core Version:    0.7.0.1
 */