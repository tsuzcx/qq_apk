import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class apiu
  extends RecyclerView.Adapter<apiw>
{
  public apiu(apiq paramapiq) {}
  
  public apiw a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558765, paramViewGroup, false);
    return new apiw(this.a, paramViewGroup);
  }
  
  @SuppressLint({"RecyclerView"})
  public void a(apiw paramapiw, int paramInt)
  {
    boolean bool = true;
    aphw localaphw = (aphw)apiq.a(this.a).get(paramInt);
    Object localObject = this.a.getContext();
    ImageView localImageView = paramapiw.jdField_a_of_type_AndroidWidgetImageView;
    String str = localaphw.c;
    if (localaphw.jdField_b_of_type_Int == 1)
    {
      bfaf.a((Context)localObject, localImageView, str, 19.0F, bool);
      paramapiw.jdField_a_of_type_AndroidWidgetTextView.setText(localaphw.jdField_b_of_type_JavaLangString);
      paramapiw.b.setText(localaphw.e);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label254;
      }
      paramapiw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      label113:
      if ((localaphw.a == null) || (localaphw.a.size() <= 0)) {
        break label269;
      }
      localObject = new Paint();
      ((Paint)localObject).setTextSize(ViewUtils.dpToPx(17.0F));
      float f1 = ViewUtils.getScreenWidth();
      float f2 = ((Paint)localObject).measureText(localaphw.jdField_b_of_type_JavaLangString);
      float f3 = mum.a(this.a.getContext(), 72.0F);
      apiq.a(this.a, (int)(f1 - f2 - f3), paramapiw.jdField_a_of_type_AndroidWidgetLinearLayout, localaphw.a);
    }
    for (;;)
    {
      paramapiw.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(mum.a);
      paramapiw.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new apiv(this, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramapiw, paramInt, getItemId(paramInt));
      return;
      bool = false;
      break;
      label254:
      paramapiw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF03081A"));
      break label113;
      label269:
      paramapiw.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public int getItemCount()
  {
    return apiq.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apiu
 * JD-Core Version:    0.7.0.1
 */