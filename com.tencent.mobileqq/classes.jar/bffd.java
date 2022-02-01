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

public class bffd
  extends bfgb<bffh, bfel>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bfff(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bfel jdField_a_of_type_Bfel;
  private bgua jdField_a_of_type_Bgua;
  private bgub jdField_a_of_type_Bgub = new bffe(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bffd(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(bfel parambfel)
  {
    if (this.b) {}
    bffh localbffh;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Bfel = parambfel;
      parambfel.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bgua = new bgua(parambfel.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bgua.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bgua.b();
      this.jdField_a_of_type_Bgua.a(this.jdField_a_of_type_Bgub);
      this.jdField_a_of_type_Bgua.b();
      localbffh = (bffh)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambfel.jdField_c_of_type_Int);
    } while (localbffh == null);
    if (parambfel.jdField_a_of_type_Boolean)
    {
      parambfel = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
      localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfel);
      parambfel.start();
      return;
    }
    localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847020);
  }
  
  private void h(bfel parambfel)
  {
    bmrl localbmrl = new bmrl(xfe.a(), parambfel.jdField_a_of_type_JavaLangString, parambfel.jdField_c_of_type_JavaLangString);
    localbmrl.a(new bffg(this, parambfel));
    parambfel.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbmrl), 8, null, true);
  }
  
  public bffh a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bffh(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561582, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Bfel);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bffh parambffh)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((bfel)parambffh.jdField_a_of_type_Bfem).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((bfel)parambffh.jdField_a_of_type_Bfem).b)));
      a((bfel)parambffh.jdField_a_of_type_Bfem);
      return;
      h((bfel)parambffh.jdField_a_of_type_Bfem);
      parambffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambffh.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bffj.a(parambffh);
    } while ((this.jdField_a_of_type_Bfel == null) || (!this.jdField_a_of_type_Bfel.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfel.jdField_c_of_type_Int != ((bfel)parambffh.jdField_a_of_type_Bfem).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Bfel);
  }
  
  public void a(bfel parambfel)
  {
    if (this.b)
    {
      if (parambfel.jdField_a_of_type_Boolean)
      {
        b(parambfel);
        return;
      }
      b(this.jdField_a_of_type_Bfel);
      c(parambfel);
      return;
    }
    c(parambfel);
  }
  
  public void a(bffh parambffh, bfel parambfel, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambffh.b.setVisibility(4);
      parambffh.c.setVisibility(4);
    }
    for (;;)
    {
      parambffh.jdField_a_of_type_AndroidWidgetTextView.setText(parambfel.jdField_a_of_type_Int + "\"");
      if (!parambfel.jdField_a_of_type_Boolean) {
        break;
      }
      parambfel = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
      parambffh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfel);
      parambfel.start();
      return;
      parambffh.b.setVisibility(0);
      switch (parambfel.g)
      {
      default: 
        break;
      case 0: 
        parambffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambffh.c.setVisibility(4);
        break;
      case 1: 
        parambffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambffh.c.setVisibility(4);
        break;
      case 2: 
        parambffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambffh.c.setVisibility(0);
        break;
      case 3: 
        parambffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambffh.c.setVisibility(4);
      }
    }
    parambffh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847020);
  }
  
  public void b(bfel parambfel)
  {
    bffh localbffh;
    if ((parambfel != null) && (parambfel.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bgua.e();
      this.jdField_a_of_type_Bgua = null;
      parambfel.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfel = null;
      localbffh = (bffh)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambfel.jdField_c_of_type_Int);
      if (localbffh != null)
      {
        if (!parambfel.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambfel = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772273);
        localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfel);
        parambfel.start();
      }
    }
    return;
    label93:
    localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847020);
  }
  
  public void c(bfel parambfel)
  {
    if ((!TextUtils.isEmpty(parambfel.jdField_a_of_type_JavaLangString)) && (new File(parambfel.jdField_a_of_type_JavaLangString).exists())) {
      g(parambfel);
    }
    while (TextUtils.isEmpty(parambfel.b)) {
      return;
    }
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693359), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambfel), 8, null, true);
  }
  
  public void d(bfel parambfel)
  {
    e(parambfel);
  }
  
  public void e(bfel parambfel)
  {
    if ((!TextUtils.isEmpty(parambfel.b)) || (parambfel.g != 0)) {
      return;
    }
    h(parambfel);
  }
  
  public void f(bfel parambfel)
  {
    if ((TextUtils.isEmpty(parambfel.b)) && (parambfel.g == 1)) {
      h(parambfel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffd
 * JD-Core Version:    0.7.0.1
 */