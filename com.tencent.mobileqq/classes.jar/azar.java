import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.2;
import java.io.File;

public class azar
  extends azbp<azav, ayzz>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azat(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ayzz jdField_a_of_type_Ayzz;
  private baka jdField_a_of_type_Baka;
  private bakb jdField_a_of_type_Bakb = new azas(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public azar(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    paramXMediaEditor = new IntentFilter();
    paramXMediaEditor.addAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    paramXMediaEditor.addAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramXMediaEditor);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void g(ayzz paramayzz)
  {
    if (this.b) {}
    azav localazav;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Ayzz = paramayzz;
      paramayzz.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Baka = new baka(paramayzz.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Baka.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Baka.b();
      this.jdField_a_of_type_Baka.a(this.jdField_a_of_type_Bakb);
      this.jdField_a_of_type_Baka.c();
      localazav = (azav)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramayzz.jdField_c_of_type_Int);
    } while (localazav == null);
    if (paramayzz.jdField_a_of_type_Boolean)
    {
      paramayzz = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772248);
      localazav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramayzz);
      paramayzz.start();
      return;
    }
    localazav.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
  }
  
  private void h(ayzz paramayzz)
  {
    bgny localbgny = new bgny(tfy.a(), paramayzz.jdField_a_of_type_JavaLangString, paramayzz.jdField_c_of_type_JavaLangString);
    localbgny.a(new azau(this, paramayzz));
    paramayzz.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbgny), 8, null, true);
  }
  
  public azav a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new azav(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495555, paramViewGroup, false));
    b(paramViewGroup.b, paramViewGroup);
    b(paramViewGroup.c, paramViewGroup);
    b(paramViewGroup.jdField_a_of_type_AndroidViewView, paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
      localLayoutParams.rightMargin = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    }
    return paramViewGroup;
  }
  
  public void a()
  {
    if (this.b) {
      b(this.jdField_a_of_type_Ayzz);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, azav paramazav)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((ayzz)paramazav.jdField_a_of_type_Azaa).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((ayzz)paramazav.jdField_a_of_type_Azaa).b)));
      a((ayzz)paramazav.jdField_a_of_type_Azaa);
      return;
      h((ayzz)paramazav.jdField_a_of_type_Azaa);
      paramazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramazav.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Azax.a(paramazav);
    } while ((this.jdField_a_of_type_Ayzz == null) || (!this.jdField_a_of_type_Ayzz.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Ayzz.jdField_c_of_type_Int != ((ayzz)paramazav.jdField_a_of_type_Azaa).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Ayzz);
  }
  
  public void a(ayzz paramayzz)
  {
    if (this.b)
    {
      if (paramayzz.jdField_a_of_type_Boolean)
      {
        b(paramayzz);
        return;
      }
      b(this.jdField_a_of_type_Ayzz);
      c(paramayzz);
      return;
    }
    c(paramayzz);
  }
  
  public void a(azav paramazav, ayzz paramayzz, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramazav.b.setVisibility(4);
      paramazav.c.setVisibility(4);
    }
    for (;;)
    {
      paramazav.jdField_a_of_type_AndroidWidgetTextView.setText(paramayzz.jdField_a_of_type_Int + "\"");
      if (!paramayzz.jdField_a_of_type_Boolean) {
        break;
      }
      paramayzz = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772248);
      paramazav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramayzz);
      paramayzz.start();
      return;
      paramazav.b.setVisibility(0);
      switch (paramayzz.g)
      {
      default: 
        break;
      case 0: 
        paramazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramazav.c.setVisibility(4);
        break;
      case 1: 
        paramazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramazav.c.setVisibility(4);
        break;
      case 2: 
        paramazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramazav.c.setVisibility(0);
        break;
      case 3: 
        paramazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramazav.c.setVisibility(4);
      }
    }
    paramazav.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
  }
  
  public void b(ayzz paramayzz)
  {
    azav localazav;
    if ((paramayzz != null) && (paramayzz.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Baka.f();
      this.jdField_a_of_type_Baka = null;
      paramayzz.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ayzz = null;
      localazav = (azav)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramayzz.jdField_c_of_type_Int);
      if (localazav != null)
      {
        if (!paramayzz.jdField_a_of_type_Boolean) {
          break label93;
        }
        paramayzz = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772248);
        localazav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramayzz);
        paramayzz.start();
      }
    }
    return;
    label93:
    localazav.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
  }
  
  public void c(ayzz paramayzz)
  {
    if ((!TextUtils.isEmpty(paramayzz.jdField_a_of_type_JavaLangString)) && (new File(paramayzz.jdField_a_of_type_JavaLangString).exists())) {
      g(paramayzz);
    }
    while (TextUtils.isEmpty(paramayzz.b)) {
      return;
    }
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131628303), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, paramayzz), 8, null, true);
  }
  
  public void d(ayzz paramayzz)
  {
    e(paramayzz);
  }
  
  public void e(ayzz paramayzz)
  {
    if ((!TextUtils.isEmpty(paramayzz.b)) || (paramayzz.g != 0)) {
      return;
    }
    h(paramayzz);
  }
  
  public void f(ayzz paramayzz)
  {
    if ((TextUtils.isEmpty(paramayzz.b)) && (paramayzz.g == 1)) {
      h(paramayzz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azar
 * JD-Core Version:    0.7.0.1
 */