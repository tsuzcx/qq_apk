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

public class azzz
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public azzz(AnonymousView paramAnonymousView) {}
  
  private void a(azzl paramazzl, baae parambaae)
  {
    paramazzl = new baaa(this, paramazzl, parambaae);
    parambaae.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramazzl);
    parambaae.g.setOnClickListener(paramazzl);
    parambaae.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramazzl);
    parambaae.h.setOnClickListener(paramazzl);
    parambaae.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramazzl);
    parambaae.f.setOnClickListener(paramazzl);
    parambaae.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(mvk.a);
    parambaae.h.setOnTouchListener(mvk.a);
    parambaae.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramazzl);
  }
  
  private void a(baae parambaae, int paramInt)
  {
    azzl localazzl = (azzl)AnonymousView.a(this.a).get(paramInt);
    parambaae.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localazzl.jdField_b_of_type_JavaLangString), 3, 16));
    parambaae.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localazzl.jdField_c_of_type_JavaLangString), 3, 16));
    parambaae.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.a.a(localazzl.jdField_c_of_type_Long));
    TextView localTextView = parambaae.jdField_c_of_type_AndroidWidgetTextView;
    String str = this.a.getContext().getString(2131698280);
    Object localObject;
    if (localazzl.g > 0L)
    {
      localObject = azsy.a((int)localazzl.g);
      localTextView.setText(String.format(str, new Object[] { localObject }));
      if (ThemeUtil.isInNightMode(this.a.a))
      {
        parambaae.jdField_b_of_type_AndroidViewViewGroup.setBackgroundResource(2130845716);
        parambaae.jdField_c_of_type_AndroidViewViewGroup.setBackgroundResource(2130845705);
      }
      if (!bdfk.b()) {
        break label317;
      }
      parambaae.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845722);
      parambaae.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845719);
      parambaae.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845721);
      parambaae.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845707);
    }
    for (;;)
    {
      int i = AnonymousView.a(this.a);
      int j = azzm.jdField_a_of_type_ArrayOfInt.length;
      parambaae.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
      parambaae.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(azzm.jdField_a_of_type_ArrayOfInt[((i + paramInt) % j)]);
      a(localazzl.jdField_b_of_type_Boolean, parambaae.jdField_d_of_type_AndroidWidgetTextView, parambaae.g, localazzl.e);
      parambaae.jdField_e_of_type_AndroidWidgetTextView.setText(azsy.a((int)localazzl.f));
      a(localazzl, parambaae);
      return;
      localObject = Long.valueOf(localazzl.g);
      break;
      label317:
      parambaae.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845717);
      parambaae.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845718);
      parambaae.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845720);
      parambaae.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845706);
    }
  }
  
  private void a(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130845782);
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localDrawable = this.a.getContext().getResources().getDrawable(2130845711);
      i = azzm.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousView", 0, String.format("setLikeUi() mPraised=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    paramTextView.setText(azsy.a((int)paramLong));
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
    return ((azzl)AnonymousView.a(this.a).get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof baah))
    {
      ((baah)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
      a((URLImageView)((baah)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof baac))
      {
        ((baac)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
        a((URLImageView)((baac)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163900_erRdzraqzD.png");
      }
      else if ((paramViewHolder instanceof baab))
      {
        ((baab)paramViewHolder).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.a);
        a((URLImageView)((baab)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
      }
      else if ((paramViewHolder instanceof baag))
      {
        ((baag)paramViewHolder).b.setOnClickListener(this.a);
        if (ThemeUtil.isInNightMode(this.a.a)) {
          ((baag)paramViewHolder).a.setBackgroundResource(2130845710);
        }
      }
      else if ((paramViewHolder instanceof baad))
      {
        ((baad)paramViewHolder).b.setOnClickListener(this.a);
        if (ThemeUtil.isInNightMode(this.a.a)) {
          ((baad)paramViewHolder).a.setBackgroundResource(2130845710);
        }
      }
      else
      {
        a((baae)paramViewHolder, paramInt);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (4 == paramInt) {
      return new baah(LayoutInflater.from(this.a.getContext()).inflate(2131561358, paramViewGroup, false));
    }
    if (5 == paramInt) {
      return new baag(LayoutInflater.from(this.a.getContext()).inflate(2131561357, paramViewGroup, false));
    }
    if (1 == paramInt) {
      return new baac(LayoutInflater.from(this.a.getContext()).inflate(2131561354, paramViewGroup, false));
    }
    if (2 == paramInt) {
      return new baab(LayoutInflater.from(this.a.getContext()).inflate(2131561353, paramViewGroup, false));
    }
    if (3 == paramInt) {
      return new baad(LayoutInflater.from(this.a.getContext()).inflate(2131561355, paramViewGroup, false));
    }
    return new baae(LayoutInflater.from(this.a.getContext()).inflate(2131561356, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzz
 * JD-Core Version:    0.7.0.1
 */