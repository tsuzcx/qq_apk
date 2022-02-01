import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class auxv
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private ajej jdField_a_of_type_Ajej;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private bjwf jdField_a_of_type_Bjwf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public auxv(Context paramContext, ajej paramajej, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845232);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_Int = AIOUtils.dp2px(32.0F, paramContext.getResources());
    this.jdField_a_of_type_Ajej = paramajej;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(auxz paramauxz, auxu paramauxu)
  {
    if ((paramauxu.a == null) || (paramauxu.a.a == null))
    {
      paramauxz.itemView.setEnabled(false);
      paramauxz.itemView.setOnLongClickListener(null);
      auxz.a(paramauxz).setVisibility(8);
      auxz.a(paramauxz).setVisibility(8);
      auxz.a(paramauxz).setEnabled(false);
      auxz.a(paramauxz).setOnClickListener(null);
      auxz.a(paramauxz).setVisibility(8);
      if (AppSetting.c)
      {
        bfpm.a(auxz.a(paramauxz), "", Button.class.getName());
        bfpm.a(paramauxz.itemView, "", Button.class.getName());
      }
    }
    label171:
    label332:
    label346:
    label477:
    for (;;)
    {
      return;
      paramauxz.itemView.setEnabled(true);
      String str;
      Object localObject;
      if ((this.jdField_a_of_type_Boolean) && (paramauxu.a.a()))
      {
        paramauxz.itemView.setOnLongClickListener(new auxw(this, paramauxz));
        if (!TextUtils.isEmpty(paramauxu.a.a.strResName)) {
          break label332;
        }
        str = "";
        auxz.a(paramauxz).setVisibility(0);
        auxz.a(paramauxz).setText(str);
        localObject = paramauxu.a.a.strGridIconUrl;
        auxz.a(paramauxz).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label346;
        }
        auxz.a(paramauxz).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label226:
        auxz.a(paramauxz).setEnabled(true);
        auxz.a(paramauxz).setVisibility(0);
        if (!paramauxu.a.a()) {
          break label440;
        }
        auxz.a(paramauxz).setOnClickListener(new auxx(this, paramauxu, paramauxz));
        auxz.a(paramauxz).setImageResource(2130850209);
      }
      for (paramauxu = this.jdField_a_of_type_AndroidContentContext.getString(2131693300);; paramauxu = this.jdField_a_of_type_AndroidContentContext.getString(2131693299))
      {
        if (!AppSetting.c) {
          break label477;
        }
        bfpm.a(auxz.a(paramauxz), paramauxu, Button.class.getName());
        bfpm.a(paramauxz.itemView, str, Button.class.getName());
        return;
        paramauxz.itemView.setOnLongClickListener(null);
        break;
        str = paramauxu.a.a.strResName;
        break label171;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Int;
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setColorFilter(-1, PorterDuff.Mode.DST_IN);
        auxz.a(paramauxz).setImageDrawable((Drawable)localObject);
        break label226;
        auxz.a(paramauxz).setOnClickListener(new auxy(this, paramauxu, paramauxz));
        auxz.a(paramauxz).setImageResource(2130850207);
      }
    }
  }
  
  public void a(bjwf parambjwf)
  {
    this.jdField_a_of_type_Bjwf = parambjwf;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Ajej.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_Ajej.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    auxu localauxu = this.jdField_a_of_type_Ajej.a(paramInt);
    if (localauxu == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof auyd))
      {
        ((auyd)paramViewHolder).a(localauxu);
      }
      else
      {
        if ((paramViewHolder instanceof auxz)) {
          a((auxz)paramViewHolder, localauxu);
        }
        if ((paramViewHolder instanceof auya)) {
          ((auya)paramViewHolder).a(localauxu, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Boolean);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561146, paramViewGroup, false);
      paramViewGroup.setTag(2131369811, Integer.valueOf(paramInt));
      return new auyd(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_b_of_type_Boolean);
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561144, paramViewGroup, false);
      paramViewGroup.setTag(2131369811, Integer.valueOf(paramInt));
      return new auxz(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager, this.jdField_b_of_type_Boolean);
    }
    if (paramInt == 3)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561145, paramViewGroup, false);
      paramViewGroup.setTag(2131369811, Integer.valueOf(paramInt));
      return new auya(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_b_of_type_Boolean);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxv
 * JD-Core Version:    0.7.0.1
 */