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

public class beof
  extends bepd<beoj, benn>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new beoh(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private benn jdField_a_of_type_Benn;
  private bgas jdField_a_of_type_Bgas;
  private bgat jdField_a_of_type_Bgat = new beog(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public beof(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(benn parambenn)
  {
    if (this.b) {}
    beoj localbeoj;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Benn = parambenn;
      parambenn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bgas = new bgas(parambenn.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bgas.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bgas.b();
      this.jdField_a_of_type_Bgas.a(this.jdField_a_of_type_Bgat);
      this.jdField_a_of_type_Bgas.b();
      localbeoj = (beoj)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambenn.jdField_c_of_type_Int);
    } while (localbeoj == null);
    if (parambenn.jdField_a_of_type_Boolean)
    {
      parambenn = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772271);
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambenn);
      parambenn.start();
      return;
    }
    localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846945);
  }
  
  private void h(benn parambenn)
  {
    bkxx localbkxx = new bkxx(wkp.a(), parambenn.jdField_a_of_type_JavaLangString, parambenn.jdField_c_of_type_JavaLangString);
    localbkxx.a(new beoi(this, parambenn));
    parambenn.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbkxx), 8, null, true);
  }
  
  public beoj a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new beoj(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561502, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Benn);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, beoj parambeoj)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((benn)parambeoj.jdField_a_of_type_Beno).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((benn)parambeoj.jdField_a_of_type_Beno).b)));
      a((benn)parambeoj.jdField_a_of_type_Beno);
      return;
      h((benn)parambeoj.jdField_a_of_type_Beno);
      parambeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambeoj.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Beol.a(parambeoj);
    } while ((this.jdField_a_of_type_Benn == null) || (!this.jdField_a_of_type_Benn.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Benn.jdField_c_of_type_Int != ((benn)parambeoj.jdField_a_of_type_Beno).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Benn);
  }
  
  public void a(benn parambenn)
  {
    if (this.b)
    {
      if (parambenn.jdField_a_of_type_Boolean)
      {
        b(parambenn);
        return;
      }
      b(this.jdField_a_of_type_Benn);
      c(parambenn);
      return;
    }
    c(parambenn);
  }
  
  public void a(beoj parambeoj, benn parambenn, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambeoj.b.setVisibility(4);
      parambeoj.c.setVisibility(4);
    }
    for (;;)
    {
      parambeoj.jdField_a_of_type_AndroidWidgetTextView.setText(parambenn.jdField_a_of_type_Int + "\"");
      if (!parambenn.jdField_a_of_type_Boolean) {
        break;
      }
      parambenn = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772271);
      parambeoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambenn);
      parambenn.start();
      return;
      parambeoj.b.setVisibility(0);
      switch (parambenn.g)
      {
      default: 
        break;
      case 0: 
        parambeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambeoj.c.setVisibility(4);
        break;
      case 1: 
        parambeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambeoj.c.setVisibility(4);
        break;
      case 2: 
        parambeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambeoj.c.setVisibility(0);
        break;
      case 3: 
        parambeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambeoj.c.setVisibility(4);
      }
    }
    parambeoj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846945);
  }
  
  public void b(benn parambenn)
  {
    beoj localbeoj;
    if ((parambenn != null) && (parambenn.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bgas.e();
      this.jdField_a_of_type_Bgas = null;
      parambenn.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Benn = null;
      localbeoj = (beoj)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambenn.jdField_c_of_type_Int);
      if (localbeoj != null)
      {
        if (!parambenn.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambenn = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772271);
        localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambenn);
        parambenn.start();
      }
    }
    return;
    label93:
    localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846945);
  }
  
  public void c(benn parambenn)
  {
    if ((!TextUtils.isEmpty(parambenn.jdField_a_of_type_JavaLangString)) && (new File(parambenn.jdField_a_of_type_JavaLangString).exists())) {
      g(parambenn);
    }
    while (TextUtils.isEmpty(parambenn.b)) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693466), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambenn), 8, null, true);
  }
  
  public void d(benn parambenn)
  {
    e(parambenn);
  }
  
  public void e(benn parambenn)
  {
    if ((!TextUtils.isEmpty(parambenn.b)) || (parambenn.g != 0)) {
      return;
    }
    h(parambenn);
  }
  
  public void f(benn parambenn)
  {
    if ((TextUtils.isEmpty(parambenn.b)) && (parambenn.g == 1)) {
      h(parambenn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beof
 * JD-Core Version:    0.7.0.1
 */