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

public class awdu
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private ajzx jdField_a_of_type_Ajzx;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private blhq jdField_a_of_type_Blhq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public awdu(Context paramContext, ajzx paramajzx, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845317);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_Int = AIOUtils.dp2px(32.0F, paramContext.getResources());
    this.jdField_a_of_type_Ajzx = paramajzx;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(awdy paramawdy, awdt paramawdt)
  {
    if ((paramawdt.a == null) || (paramawdt.a.a == null))
    {
      paramawdy.itemView.setEnabled(false);
      paramawdy.itemView.setOnLongClickListener(null);
      awdy.a(paramawdy).setVisibility(8);
      awdy.a(paramawdy).setVisibility(8);
      awdy.a(paramawdy).setEnabled(false);
      awdy.a(paramawdy).setOnClickListener(null);
      awdy.a(paramawdy).setVisibility(8);
      if (AppSetting.c)
      {
        bgyd.a(awdy.a(paramawdy), "", Button.class.getName());
        bgyd.a(paramawdy.itemView, "", Button.class.getName());
      }
    }
    label171:
    label332:
    label346:
    label477:
    for (;;)
    {
      return;
      paramawdy.itemView.setEnabled(true);
      String str;
      Object localObject;
      if ((this.jdField_a_of_type_Boolean) && (paramawdt.a.a()))
      {
        paramawdy.itemView.setOnLongClickListener(new awdv(this, paramawdy));
        if (!TextUtils.isEmpty(paramawdt.a.a.strResName)) {
          break label332;
        }
        str = "";
        awdy.a(paramawdy).setVisibility(0);
        awdy.a(paramawdy).setText(str);
        localObject = paramawdt.a.a.strGridIconUrl;
        awdy.a(paramawdy).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label346;
        }
        awdy.a(paramawdy).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label226:
        awdy.a(paramawdy).setEnabled(true);
        awdy.a(paramawdy).setVisibility(0);
        if (!paramawdt.a.a()) {
          break label440;
        }
        awdy.a(paramawdy).setOnClickListener(new awdw(this, paramawdt, paramawdy));
        awdy.a(paramawdy).setImageResource(2130850311);
      }
      for (paramawdt = this.jdField_a_of_type_AndroidContentContext.getString(2131693480);; paramawdt = this.jdField_a_of_type_AndroidContentContext.getString(2131693479))
      {
        if (!AppSetting.c) {
          break label477;
        }
        bgyd.a(awdy.a(paramawdy), paramawdt, Button.class.getName());
        bgyd.a(paramawdy.itemView, str, Button.class.getName());
        return;
        paramawdy.itemView.setOnLongClickListener(null);
        break;
        str = paramawdt.a.a.strResName;
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
        awdy.a(paramawdy).setImageDrawable((Drawable)localObject);
        break label226;
        awdy.a(paramawdy).setOnClickListener(new awdx(this, paramawdt, paramawdy));
        awdy.a(paramawdy).setImageResource(2130850309);
      }
    }
  }
  
  public void a(blhq paramblhq)
  {
    this.jdField_a_of_type_Blhq = paramblhq;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Ajzx.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_Ajzx.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    awdt localawdt = this.jdField_a_of_type_Ajzx.a(paramInt);
    if (localawdt == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof awec))
      {
        ((awec)paramViewHolder).a(localawdt);
      }
      else
      {
        if ((paramViewHolder instanceof awdy)) {
          a((awdy)paramViewHolder, localawdt);
        }
        if ((paramViewHolder instanceof awdz)) {
          ((awdz)paramViewHolder).a(localawdt, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Boolean);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561207, paramViewGroup, false);
      paramViewGroup.setTag(2131369981, Integer.valueOf(paramInt));
      return new awec(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_b_of_type_Boolean);
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561205, paramViewGroup, false);
      paramViewGroup.setTag(2131369981, Integer.valueOf(paramInt));
      return new awdy(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager, this.jdField_b_of_type_Boolean);
    }
    if (paramInt == 3)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561206, paramViewGroup, false);
      paramViewGroup.setTag(2131369981, Integer.valueOf(paramInt));
      return new awdz(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_b_of_type_Boolean);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdu
 * JD-Core Version:    0.7.0.1
 */