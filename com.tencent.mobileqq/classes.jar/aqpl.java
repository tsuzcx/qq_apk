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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aqpl
  extends RecyclerView.Adapter<aqpn>
{
  public aqpl(aqph paramaqph) {}
  
  public aqpn a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558757, paramViewGroup, false);
    return new aqpn(this.a, paramViewGroup);
  }
  
  @SuppressLint({"RecyclerView"})
  public void a(aqpn paramaqpn, int paramInt)
  {
    boolean bool = true;
    aqon localaqon = (aqon)aqph.a(this.a).get(paramInt);
    Object localObject = this.a.getContext();
    ImageView localImageView = paramaqpn.jdField_a_of_type_AndroidWidgetImageView;
    String str = localaqon.c;
    if (localaqon.jdField_b_of_type_Int == 1)
    {
      bgqr.a((Context)localObject, localImageView, str, 19.0F, bool);
      paramaqpn.jdField_a_of_type_AndroidWidgetTextView.setText(localaqon.jdField_b_of_type_JavaLangString);
      paramaqpn.b.setText(localaqon.e);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label254;
      }
      paramaqpn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      label113:
      if ((localaqon.a == null) || (localaqon.a.size() <= 0)) {
        break label269;
      }
      localObject = new Paint();
      ((Paint)localObject).setTextSize(bhtq.b(17.0F));
      float f1 = bhtq.a();
      float f2 = ((Paint)localObject).measureText(localaqon.jdField_b_of_type_JavaLangString);
      float f3 = mvd.a(this.a.getContext(), 72.0F);
      aqph.a(this.a, (int)(f1 - f2 - f3), paramaqpn.jdField_a_of_type_AndroidWidgetLinearLayout, localaqon.a);
    }
    for (;;)
    {
      paramaqpn.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(mvd.a);
      paramaqpn.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new aqpm(this, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaqpn, paramInt, getItemId(paramInt));
      return;
      bool = false;
      break;
      label254:
      paramaqpn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF03081A"));
      break label113;
      label269:
      paramaqpn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public int getItemCount()
  {
    return aqph.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpl
 * JD-Core Version:    0.7.0.1
 */