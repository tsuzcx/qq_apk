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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class bfvi
  extends bfwg<bfvm, bfuq>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bfvk(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bfuq jdField_a_of_type_Bfuq;
  private bhjj jdField_a_of_type_Bhjj;
  private bhjk jdField_a_of_type_Bhjk = new bfvj(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bfvi(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(bfuq parambfuq)
  {
    if (this.b) {}
    bfvm localbfvm;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Bfuq = parambfuq;
      parambfuq.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bhjj = new bhjj(parambfuq.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bhjj.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bhjj.b();
      this.jdField_a_of_type_Bhjj.a(this.jdField_a_of_type_Bhjk);
      this.jdField_a_of_type_Bhjj.b();
      localbfvm = (bfvm)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambfuq.jdField_c_of_type_Int);
    } while (localbfvm == null);
    if (parambfuq.jdField_a_of_type_Boolean)
    {
      parambfuq = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772270);
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfuq);
      parambfuq.start();
      return;
    }
    localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847042);
  }
  
  private void h(bfuq parambfuq)
  {
    bmjg localbmjg = new bmjg(wzk.a(), parambfuq.jdField_a_of_type_JavaLangString, parambfuq.jdField_c_of_type_JavaLangString);
    localbmjg.a(new bfvl(this, parambfuq));
    parambfuq.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbmjg), 8, null, true);
  }
  
  public bfvm a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bfvm(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561564, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Bfuq);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bfvm parambfvm)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((bfuq)parambfvm.jdField_a_of_type_Bfur).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((bfuq)parambfvm.jdField_a_of_type_Bfur).b)));
      a((bfuq)parambfvm.jdField_a_of_type_Bfur);
      return;
      h((bfuq)parambfvm.jdField_a_of_type_Bfur);
      parambfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambfvm.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bfvo.a(parambfvm);
    } while ((this.jdField_a_of_type_Bfuq == null) || (!this.jdField_a_of_type_Bfuq.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfuq.jdField_c_of_type_Int != ((bfuq)parambfvm.jdField_a_of_type_Bfur).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Bfuq);
  }
  
  public void a(bfuq parambfuq)
  {
    if (this.b)
    {
      if (parambfuq.jdField_a_of_type_Boolean)
      {
        b(parambfuq);
        return;
      }
      b(this.jdField_a_of_type_Bfuq);
      c(parambfuq);
      return;
    }
    c(parambfuq);
  }
  
  public void a(bfvm parambfvm, bfuq parambfuq, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambfvm.b.setVisibility(4);
      parambfvm.c.setVisibility(4);
    }
    for (;;)
    {
      parambfvm.jdField_a_of_type_AndroidWidgetTextView.setText(parambfuq.jdField_a_of_type_Int + "\"");
      if (!parambfuq.jdField_a_of_type_Boolean) {
        break;
      }
      parambfuq = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772270);
      parambfvm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfuq);
      parambfuq.start();
      return;
      parambfvm.b.setVisibility(0);
      switch (parambfuq.g)
      {
      default: 
        break;
      case 0: 
        parambfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambfvm.c.setVisibility(4);
        break;
      case 1: 
        parambfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambfvm.c.setVisibility(4);
        break;
      case 2: 
        parambfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambfvm.c.setVisibility(0);
        break;
      case 3: 
        parambfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambfvm.c.setVisibility(4);
      }
    }
    parambfvm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847042);
  }
  
  public void b(bfuq parambfuq)
  {
    bfvm localbfvm;
    if ((parambfuq != null) && (parambfuq.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bhjj.e();
      this.jdField_a_of_type_Bhjj = null;
      parambfuq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfuq = null;
      localbfvm = (bfvm)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambfuq.jdField_c_of_type_Int);
      if (localbfvm != null)
      {
        if (!parambfuq.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambfuq = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772270);
        localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambfuq);
        parambfuq.start();
      }
    }
    return;
    label93:
    localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847042);
  }
  
  public void c(bfuq parambfuq)
  {
    if ((!TextUtils.isEmpty(parambfuq.jdField_a_of_type_JavaLangString)) && (new File(parambfuq.jdField_a_of_type_JavaLangString).exists())) {
      g(parambfuq);
    }
    while (TextUtils.isEmpty(parambfuq.b)) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693647), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambfuq), 8, null, true);
  }
  
  public void d(bfuq parambfuq)
  {
    e(parambfuq);
  }
  
  public void e(bfuq parambfuq)
  {
    if ((!TextUtils.isEmpty(parambfuq.b)) || (parambfuq.g != 0)) {
      return;
    }
    h(parambfuq);
  }
  
  public void f(bfuq parambfuq)
  {
    if ((TextUtils.isEmpty(parambfuq.b)) && (parambfuq.g == 1)) {
      h(parambfuq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvi
 * JD-Core Version:    0.7.0.1
 */