import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;

public class ayvd
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public ayvd(AnonymousView paramAnonymousView) {}
  
  private void a(ayup paramayup, ayvi paramayvi)
  {
    paramayup = new ayve(this, paramayup, paramayvi);
    paramayvi.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramayup);
    paramayvi.g.setOnClickListener(paramayup);
    paramayvi.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramayup);
    paramayvi.h.setOnClickListener(paramayup);
    paramayvi.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramayup);
    paramayvi.f.setOnClickListener(paramayup);
    paramayvi.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(mum.a);
    paramayvi.h.setOnTouchListener(mum.a);
    paramayvi.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramayup);
  }
  
  private void a(ayvi paramayvi, int paramInt)
  {
    ayup localayup = (ayup)AnonymousView.a(this.a).get(paramInt);
    paramayvi.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localayup.jdField_b_of_type_JavaLangString), 3, 16));
    paramayvi.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localayup.jdField_c_of_type_JavaLangString), 3, 16));
    paramayvi.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.a.a(localayup.jdField_c_of_type_Long));
    TextView localTextView = paramayvi.jdField_c_of_type_AndroidWidgetTextView;
    String str = this.a.getContext().getString(2131697995);
    Object localObject;
    if (localayup.g > 0L)
    {
      localObject = ayod.a((int)localayup.g);
      localTextView.setText(String.format(str, new Object[] { localObject }));
      if (ThemeUtil.isInNightMode(this.a.a))
      {
        paramayvi.jdField_b_of_type_AndroidViewViewGroup.setBackgroundResource(2130845631);
        paramayvi.jdField_c_of_type_AndroidViewViewGroup.setBackgroundResource(2130845620);
      }
      if (!bbyp.b()) {
        break label317;
      }
      paramayvi.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845637);
      paramayvi.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      paramayvi.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845636);
      paramayvi.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845622);
    }
    for (;;)
    {
      int i = AnonymousView.a(this.a);
      int j = ayuq.jdField_a_of_type_ArrayOfInt.length;
      paramayvi.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
      paramayvi.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(ayuq.jdField_a_of_type_ArrayOfInt[((i + paramInt) % j)]);
      a(localayup.jdField_b_of_type_Boolean, paramayvi.jdField_d_of_type_AndroidWidgetTextView, paramayvi.g, localayup.e);
      paramayvi.jdField_e_of_type_AndroidWidgetTextView.setText(ayod.a((int)localayup.f));
      a(localayup, paramayvi);
      return;
      localObject = Long.valueOf(localayup.g);
      break;
      label317:
      paramayvi.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845632);
      paramayvi.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845633);
      paramayvi.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845635);
      paramayvi.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845621);
    }
  }
  
  private void a(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130845694);
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localDrawable = this.a.getContext().getResources().getDrawable(2130845626);
      i = ayuq.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousView", 0, String.format("setLikeUi() mPraised=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    paramTextView.setText(ayod.a((int)paramLong));
    paramTextView.setTextColor(i);
    paramImageView.setImageDrawable(localDrawable);
  }
  
  private boolean a(URLImageView paramURLImageView, String paramString)
  {
    if (((AnonymousView.a(this.a)) || (ThemeUtil.isInNightMode(this.a.a))) && (paramURLImageView != null))
    {
      paramURLImageView.setVisibility(4);
      return false;
    }
    if ((paramURLImageView != null) && (paramString != null)) {
      paramURLImageView.setImageURL(paramString);
    }
    return true;
  }
  
  public int getItemCount()
  {
    return AnonymousView.a(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ayup)AnonymousView.a(this.a).get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ayvl))
    {
      ((ayvl)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
      a((URLImageView)((ayvl)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof ayvg))
      {
        ((ayvg)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
        a((URLImageView)((ayvg)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163900_erRdzraqzD.png");
      }
      else if ((paramViewHolder instanceof ayvf))
      {
        ((ayvf)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
        a((URLImageView)((ayvf)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
      }
      else if ((paramViewHolder instanceof ayvk))
      {
        ((ayvk)paramViewHolder).b.setOnClickListener(this.a);
        if (ThemeUtil.isInNightMode(this.a.a)) {
          ((ayvk)paramViewHolder).a.setBackgroundResource(2130845625);
        }
      }
      else if ((paramViewHolder instanceof ayvh))
      {
        ((ayvh)paramViewHolder).b.setOnClickListener(this.a);
        if (ThemeUtil.isInNightMode(this.a.a)) {
          ((ayvh)paramViewHolder).a.setBackgroundResource(2130845625);
        }
      }
      else
      {
        a((ayvi)paramViewHolder, paramInt);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (4 == paramInt) {
      return new ayvl(LayoutInflater.from(this.a.getContext()).inflate(2131561297, paramViewGroup, false));
    }
    if (5 == paramInt) {
      return new ayvk(LayoutInflater.from(this.a.getContext()).inflate(2131561296, paramViewGroup, false));
    }
    if (1 == paramInt) {
      return new ayvg(LayoutInflater.from(this.a.getContext()).inflate(2131561293, paramViewGroup, false));
    }
    if (2 == paramInt) {
      return new ayvf(LayoutInflater.from(this.a.getContext()).inflate(2131561292, paramViewGroup, false));
    }
    if (3 == paramInt) {
      return new ayvh(LayoutInflater.from(this.a.getContext()).inflate(2131561294, paramViewGroup, false));
    }
    return new ayvi(LayoutInflater.from(this.a.getContext()).inflate(2131561295, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvd
 * JD-Core Version:    0.7.0.1
 */