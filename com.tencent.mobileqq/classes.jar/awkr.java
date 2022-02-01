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
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class awkr
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private akgq jdField_a_of_type_Akgq;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private blsg jdField_a_of_type_Blsg;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public awkr(Context paramContext, akgq paramakgq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845353);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.b = agej.a(32.0F, paramContext.getResources());
    this.jdField_a_of_type_Akgq = paramakgq;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(awkv paramawkv, awkq paramawkq)
  {
    if ((paramawkq.a == null) || (paramawkq.a.a == null))
    {
      paramawkv.itemView.setEnabled(false);
      paramawkv.itemView.setOnLongClickListener(null);
      awkv.a(paramawkv).setVisibility(8);
      awkv.a(paramawkv).setVisibility(8);
      awkv.a(paramawkv).setEnabled(false);
      awkv.a(paramawkv).setOnClickListener(null);
      awkv.a(paramawkv).setVisibility(8);
      if (AppSetting.c)
      {
        bhga.a(awkv.a(paramawkv), "", Button.class.getName());
        bhga.a(paramawkv.itemView, "", Button.class.getName());
      }
    }
    label171:
    label332:
    label346:
    label477:
    for (;;)
    {
      return;
      paramawkv.itemView.setEnabled(true);
      String str;
      Object localObject;
      if ((this.jdField_a_of_type_Boolean) && (paramawkq.a.a()))
      {
        paramawkv.itemView.setOnLongClickListener(new awks(this, paramawkv));
        if (!TextUtils.isEmpty(paramawkq.a.a.strResName)) {
          break label332;
        }
        str = "";
        awkv.a(paramawkv).setVisibility(0);
        awkv.a(paramawkv).setText(str);
        localObject = paramawkq.a.a.strGridIconUrl;
        awkv.a(paramawkv).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label346;
        }
        awkv.a(paramawkv).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label226:
        awkv.a(paramawkv).setEnabled(true);
        awkv.a(paramawkv).setVisibility(0);
        if (!paramawkq.a.a()) {
          break label440;
        }
        awkv.a(paramawkv).setOnClickListener(new awkt(this, paramawkq, paramawkv));
        awkv.a(paramawkv).setImageResource(2130850288);
      }
      for (paramawkq = this.jdField_a_of_type_AndroidContentContext.getString(2131693211);; paramawkq = this.jdField_a_of_type_AndroidContentContext.getString(2131693210))
      {
        if (!AppSetting.c) {
          break label477;
        }
        bhga.a(awkv.a(paramawkv), paramawkq, Button.class.getName());
        bhga.a(paramawkv.itemView, str, Button.class.getName());
        return;
        paramawkv.itemView.setOnLongClickListener(null);
        break;
        str = paramawkq.a.a.strResName;
        break label171;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.b;
        localURLDrawableOptions.mRequestHeight = this.b;
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setColorFilter(-1, PorterDuff.Mode.DST_IN);
        awkv.a(paramawkv).setImageDrawable((Drawable)localObject);
        break label226;
        awkv.a(paramawkv).setOnClickListener(new awku(this, paramawkq, paramawkv));
        awkv.a(paramawkv).setImageResource(2130850286);
      }
    }
  }
  
  public void a(blsg paramblsg)
  {
    this.jdField_a_of_type_Blsg = paramblsg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Akgq.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_Akgq.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    awkq localawkq = this.jdField_a_of_type_Akgq.a(paramInt);
    if (localawkq == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof awla))
      {
        ((awla)paramViewHolder).a(localawkq);
      }
      else
      {
        if ((paramViewHolder instanceof awkv)) {
          a((awkv)paramViewHolder, localawkq);
        }
        if ((paramViewHolder instanceof awkw)) {
          ((awkw)paramViewHolder).a(localawkq);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561271, paramViewGroup, false);
      paramViewGroup.setTag(2131369821, Integer.valueOf(paramInt));
      return new awla(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561269, paramViewGroup, false);
      paramViewGroup.setTag(2131369821, Integer.valueOf(paramInt));
      return new awkv(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    }
    if (paramInt == 3)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561270, paramViewGroup, false);
      paramViewGroup.setTag(2131369821, Integer.valueOf(paramInt));
      return new awkw(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkr
 * JD-Core Version:    0.7.0.1
 */