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

public class babx
  extends bacv<bacb, babf>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new babz(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private babf jdField_a_of_type_Babf;
  private bbly jdField_a_of_type_Bbly;
  private bblz jdField_a_of_type_Bblz = new baby(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public babx(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(babf parambabf)
  {
    if (this.b) {}
    bacb localbacb;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Babf = parambabf;
      parambabf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bbly = new bbly(parambabf.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bbly.b();
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblz);
      this.jdField_a_of_type_Bbly.c();
      localbacb = (bacb)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambabf.jdField_c_of_type_Int);
    } while (localbacb == null);
    if (parambabf.jdField_a_of_type_Boolean)
    {
      parambabf = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambabf);
      parambabf.start();
      return;
    }
    localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846127);
  }
  
  private void h(babf parambabf)
  {
    bhxj localbhxj = new bhxj(tsr.a(), parambabf.jdField_a_of_type_JavaLangString, parambabf.jdField_c_of_type_JavaLangString);
    localbhxj.a(new baca(this, parambabf));
    parambabf.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbhxj), 8, null, true);
  }
  
  public bacb a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bacb(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561143, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Babf);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bacb parambacb)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((babf)parambacb.jdField_a_of_type_Babg).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((babf)parambacb.jdField_a_of_type_Babg).b)));
      a((babf)parambacb.jdField_a_of_type_Babg);
      return;
      h((babf)parambacb.jdField_a_of_type_Babg);
      parambacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambacb.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bacd.a(parambacb);
    } while ((this.jdField_a_of_type_Babf == null) || (!this.jdField_a_of_type_Babf.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Babf.jdField_c_of_type_Int != ((babf)parambacb.jdField_a_of_type_Babg).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Babf);
  }
  
  public void a(babf parambabf)
  {
    if (this.b)
    {
      if (parambabf.jdField_a_of_type_Boolean)
      {
        b(parambabf);
        return;
      }
      b(this.jdField_a_of_type_Babf);
      c(parambabf);
      return;
    }
    c(parambabf);
  }
  
  public void a(bacb parambacb, babf parambabf, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambacb.b.setVisibility(4);
      parambacb.c.setVisibility(4);
    }
    for (;;)
    {
      parambacb.jdField_a_of_type_AndroidWidgetTextView.setText(parambabf.jdField_a_of_type_Int + "\"");
      if (!parambabf.jdField_a_of_type_Boolean) {
        break;
      }
      parambabf = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
      parambacb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambabf);
      parambabf.start();
      return;
      parambacb.b.setVisibility(0);
      switch (parambabf.g)
      {
      default: 
        break;
      case 0: 
        parambacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambacb.c.setVisibility(4);
        break;
      case 1: 
        parambacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambacb.c.setVisibility(4);
        break;
      case 2: 
        parambacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambacb.c.setVisibility(0);
        break;
      case 3: 
        parambacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambacb.c.setVisibility(4);
      }
    }
    parambacb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846127);
  }
  
  public void b(babf parambabf)
  {
    bacb localbacb;
    if ((parambabf != null) && (parambabf.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
      parambabf.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Babf = null;
      localbacb = (bacb)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambabf.jdField_c_of_type_Int);
      if (localbacb != null)
      {
        if (!parambabf.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambabf = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
        localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambabf);
        parambabf.start();
      }
    }
    return;
    label93:
    localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846127);
  }
  
  public void c(babf parambabf)
  {
    if ((!TextUtils.isEmpty(parambabf.jdField_a_of_type_JavaLangString)) && (new File(parambabf.jdField_a_of_type_JavaLangString).exists())) {
      g(parambabf);
    }
    while (TextUtils.isEmpty(parambabf.b)) {
      return;
    }
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693945), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambabf), 8, null, true);
  }
  
  public void d(babf parambabf)
  {
    e(parambabf);
  }
  
  public void e(babf parambabf)
  {
    if ((!TextUtils.isEmpty(parambabf.b)) || (parambabf.g != 0)) {
      return;
    }
    h(parambabf);
  }
  
  public void f(babf parambabf)
  {
    if ((TextUtils.isEmpty(parambabf.b)) && (parambabf.g == 1)) {
      h(parambabf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babx
 * JD-Core Version:    0.7.0.1
 */