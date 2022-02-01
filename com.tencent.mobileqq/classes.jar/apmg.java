import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class apmg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  apmc jdField_a_of_type_Apmc;
  apmd jdField_a_of_type_Apmd;
  public View b;
  public TextView b;
  
  public apmg(apmc paramapmc, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Apmc = paramapmc;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371895);
    bfpm.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371896);
    bfpm.a(localView2, false);
    localView2.setOnClickListener(this);
    if (apmc.a(paramapmc))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!apmc.a(paramapmc)) {
        break label334;
      }
    }
    label334:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371888);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690801));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371885);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371889));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371899));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bfpm.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371897));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bfpm.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371890));
      this.jdField_a_of_type_Apmd = new apmd(paramapmc, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Apmd);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new apme(paramapmc, this));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MusicDanceDrawable();
      ((apkz)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(paramView.getContext(), AIOUtils.dp2px(15.0F, localResources), AIOUtils.dp2px(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)apmc.a(this.jdField_a_of_type_Apmc).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (apmc.a(this.jdField_a_of_type_Apmc) != null)
      {
        apmc.a(this.jdField_a_of_type_Apmc).b();
        bcef.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmg
 * JD-Core Version:    0.7.0.1
 */