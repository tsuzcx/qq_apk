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

public class aqly
  extends RecyclerView.Adapter<aqma>
{
  public aqly(aqlu paramaqlu) {}
  
  public aqma a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558790, paramViewGroup, false);
    return new aqma(this.a, paramViewGroup);
  }
  
  @SuppressLint({"RecyclerView"})
  public void a(aqma paramaqma, int paramInt)
  {
    boolean bool = true;
    aqla localaqla = (aqla)aqlu.a(this.a).get(paramInt);
    Object localObject = this.a.getContext();
    ImageView localImageView = paramaqma.jdField_a_of_type_AndroidWidgetImageView;
    String str = localaqla.c;
    if (localaqla.jdField_b_of_type_Int == 1)
    {
      bgil.a((Context)localObject, localImageView, str, 19.0F, bool);
      paramaqma.jdField_a_of_type_AndroidWidgetTextView.setText(localaqla.jdField_b_of_type_JavaLangString);
      paramaqma.b.setText(localaqla.e);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label254;
      }
      paramaqma.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      label113:
      if ((localaqla.a == null) || (localaqla.a.size() <= 0)) {
        break label269;
      }
      localObject = new Paint();
      ((Paint)localObject).setTextSize(ViewUtils.dpToPx(17.0F));
      float f1 = ViewUtils.getScreenWidth();
      float f2 = ((Paint)localObject).measureText(localaqla.jdField_b_of_type_JavaLangString);
      float f3 = mvk.a(this.a.getContext(), 72.0F);
      aqlu.a(this.a, (int)(f1 - f2 - f3), paramaqma.jdField_a_of_type_AndroidWidgetLinearLayout, localaqla.a);
    }
    for (;;)
    {
      paramaqma.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(mvk.a);
      paramaqma.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new aqlz(this, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaqma, paramInt, getItemId(paramInt));
      return;
      bool = false;
      break;
      label254:
      paramaqma.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF03081A"));
      break label113;
      label269:
      paramaqma.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public int getItemCount()
  {
    return aqlu.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqly
 * JD-Core Version:    0.7.0.1
 */