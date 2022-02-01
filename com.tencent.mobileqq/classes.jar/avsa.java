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

public class avsa
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private ajvh jdField_a_of_type_Ajvh;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private bkrd jdField_a_of_type_Bkrd;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public avsa(Context paramContext, ajvh paramajvh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845338);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.b = afur.a(32.0F, paramContext.getResources());
    this.jdField_a_of_type_Ajvh = paramajvh;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(avse paramavse, avrz paramavrz)
  {
    if ((paramavrz.a == null) || (paramavrz.a.a == null))
    {
      paramavse.itemView.setEnabled(false);
      paramavse.itemView.setOnLongClickListener(null);
      avse.a(paramavse).setVisibility(8);
      avse.a(paramavse).setVisibility(8);
      avse.a(paramavse).setEnabled(false);
      avse.a(paramavse).setOnClickListener(null);
      avse.a(paramavse).setVisibility(8);
      if (AppSetting.c) {
        bgfz.a(avse.a(paramavse), "", Button.class.getName());
      }
    }
    label157:
    label303:
    label441:
    for (;;)
    {
      return;
      paramavse.itemView.setEnabled(true);
      Object localObject;
      if ((this.jdField_a_of_type_Boolean) && (paramavrz.a.a()))
      {
        paramavse.itemView.setOnLongClickListener(new avsb(this, paramavse));
        if (!TextUtils.isEmpty(paramavrz.a.a.strResName)) {
          break label303;
        }
        localObject = "";
        avse.a(paramavse).setVisibility(0);
        avse.a(paramavse).setText((CharSequence)localObject);
        localObject = paramavrz.a.a.strGridIconUrl;
        avse.a(paramavse).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label317;
        }
        avse.a(paramavse).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label210:
        avse.a(paramavse).setEnabled(true);
        avse.a(paramavse).setVisibility(0);
        if (!paramavrz.a.a()) {
          break label404;
        }
        avse.a(paramavse).setOnClickListener(new avsc(this, paramavrz, paramavse));
        avse.a(paramavse).setImageResource(2130850276);
      }
      for (paramavrz = this.jdField_a_of_type_AndroidContentContext.getString(2131693199);; paramavrz = this.jdField_a_of_type_AndroidContentContext.getString(2131693198))
      {
        if (!AppSetting.c) {
          break label441;
        }
        bgfz.a(avse.a(paramavse), paramavrz, Button.class.getName());
        return;
        paramavse.itemView.setOnLongClickListener(null);
        break;
        localObject = paramavrz.a.a.strResName;
        break label157;
        label317:
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
        avse.a(paramavse).setImageDrawable((Drawable)localObject);
        break label210;
        avse.a(paramavse).setOnClickListener(new avsd(this, paramavrz, paramavse));
        avse.a(paramavse).setImageResource(2130850274);
      }
    }
  }
  
  public void a(bkrd parambkrd)
  {
    this.jdField_a_of_type_Bkrd = parambkrd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Ajvh.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_Ajvh.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    avrz localavrz = this.jdField_a_of_type_Ajvh.a(paramInt);
    if (localavrz == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof avsf)) {
        ((avsf)paramViewHolder).a(localavrz);
      } else if ((paramViewHolder instanceof avse)) {
        a((avse)paramViewHolder, localavrz);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561233, paramViewGroup, false);
      paramViewGroup.setTag(2131369726, Integer.valueOf(paramInt));
      return new avsf(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561232, paramViewGroup, false);
      paramViewGroup.setTag(2131369726, Integer.valueOf(paramInt));
      return new avse(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsa
 * JD-Core Version:    0.7.0.1
 */