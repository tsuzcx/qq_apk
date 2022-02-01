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
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class bgex
  extends bgfv<bgfb, bgef>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bgez(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bgef jdField_a_of_type_Bgef;
  private bhud jdField_a_of_type_Bhud;
  private bhue jdField_a_of_type_Bhue = new bgey(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bgex(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(bgef parambgef)
  {
    if (this.b) {}
    bgfb localbgfb;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Bgef = parambgef;
      parambgef.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bhud = new bhud(parambgef.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bhud.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bhud.b();
      this.jdField_a_of_type_Bhud.a(this.jdField_a_of_type_Bhue);
      this.jdField_a_of_type_Bhud.b();
      localbgfb = (bgfb)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambgef.jdField_c_of_type_Int);
    } while (localbgfb == null);
    if (parambgef.jdField_a_of_type_Boolean)
    {
      parambgef = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambgef);
      parambgef.start();
      return;
    }
    localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847037);
  }
  
  private void h(bgef parambgef)
  {
    bnsq localbnsq = new bnsq(xiz.a(), parambgef.jdField_a_of_type_JavaLangString, parambgef.jdField_c_of_type_JavaLangString);
    localbnsq.a(new bgfa(this, parambgef));
    parambgef.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbnsq), 8, null, true);
  }
  
  public bgfb a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bgfb(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561623, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Bgef);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bgfb parambgfb)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((bgef)parambgfb.jdField_a_of_type_Bgeg).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((bgef)parambgfb.jdField_a_of_type_Bgeg).b)));
      a((bgef)parambgfb.jdField_a_of_type_Bgeg);
      return;
      h((bgef)parambgfb.jdField_a_of_type_Bgeg);
      parambgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambgfb.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bgfd.a(parambgfb);
    } while ((this.jdField_a_of_type_Bgef == null) || (!this.jdField_a_of_type_Bgef.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bgef.jdField_c_of_type_Int != ((bgef)parambgfb.jdField_a_of_type_Bgeg).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Bgef);
  }
  
  public void a(bgef parambgef)
  {
    if (this.b)
    {
      if (parambgef.jdField_a_of_type_Boolean)
      {
        b(parambgef);
        return;
      }
      b(this.jdField_a_of_type_Bgef);
      c(parambgef);
      return;
    }
    c(parambgef);
  }
  
  public void a(bgfb parambgfb, bgef parambgef, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambgfb.b.setVisibility(4);
      parambgfb.c.setVisibility(4);
    }
    for (;;)
    {
      parambgfb.jdField_a_of_type_AndroidWidgetTextView.setText(parambgef.jdField_a_of_type_Int + "\"");
      if (!parambgef.jdField_a_of_type_Boolean) {
        break;
      }
      parambgef = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
      parambgfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambgef);
      parambgef.start();
      return;
      parambgfb.b.setVisibility(0);
      switch (parambgef.g)
      {
      default: 
        break;
      case 0: 
        parambgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambgfb.c.setVisibility(4);
        break;
      case 1: 
        parambgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambgfb.c.setVisibility(4);
        break;
      case 2: 
        parambgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambgfb.c.setVisibility(0);
        break;
      case 3: 
        parambgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambgfb.c.setVisibility(4);
      }
    }
    parambgfb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847037);
  }
  
  public void b(bgef parambgef)
  {
    bgfb localbgfb;
    if ((parambgef != null) && (parambgef.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
      parambgef.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bgef = null;
      localbgfb = (bgfb)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambgef.jdField_c_of_type_Int);
      if (localbgfb != null)
      {
        if (!parambgef.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambgef = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
        localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambgef);
        parambgef.start();
      }
    }
    return;
    label93:
    localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847037);
  }
  
  public void c(bgef parambgef)
  {
    if ((!TextUtils.isEmpty(parambgef.jdField_a_of_type_JavaLangString)) && (new File(parambgef.jdField_a_of_type_JavaLangString).exists())) {
      g(parambgef);
    }
    while (TextUtils.isEmpty(parambgef.b)) {
      return;
    }
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693371), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambgef), 8, null, true);
  }
  
  public void d(bgef parambgef)
  {
    e(parambgef);
  }
  
  public void e(bgef parambgef)
  {
    if ((!TextUtils.isEmpty(parambgef.b)) || (parambgef.g != 0)) {
      return;
    }
    h(parambgef);
  }
  
  public void f(bgef parambgef)
  {
    if ((TextUtils.isEmpty(parambgef.b)) && (parambgef.g == 1)) {
      h(parambgef);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgex
 * JD-Core Version:    0.7.0.1
 */