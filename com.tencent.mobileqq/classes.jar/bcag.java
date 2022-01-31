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

public class bcag
  extends bcbe<bcak, bbzo>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bcai(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bbzo jdField_a_of_type_Bbzo;
  private bdks jdField_a_of_type_Bdks;
  private bdkt jdField_a_of_type_Bdkt = new bcah(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bcag(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(bbzo parambbzo)
  {
    if (this.b) {}
    bcak localbcak;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Bbzo = parambbzo;
      parambbzo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bdks = new bdks(parambbzo.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bdks.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bdks.b();
      this.jdField_a_of_type_Bdks.a(this.jdField_a_of_type_Bdkt);
      this.jdField_a_of_type_Bdks.c();
      localbcak = (bcak)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambbzo.jdField_c_of_type_Int);
    } while (localbcak == null);
    if (parambbzo.jdField_a_of_type_Boolean)
    {
      parambbzo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772263);
      localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambbzo);
      parambbzo.start();
      return;
    }
    localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846506);
  }
  
  private void h(bbzo parambbzo)
  {
    bjyu localbjyu = new bjyu(vhj.a(), parambbzo.jdField_a_of_type_JavaLangString, parambbzo.jdField_c_of_type_JavaLangString);
    localbjyu.a(new bcaj(this, parambbzo));
    parambbzo.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbjyu), 8, null, true);
  }
  
  public bcak a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bcak(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561331, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Bbzo);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bcak parambcak)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((bbzo)parambcak.jdField_a_of_type_Bbzp).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((bbzo)parambcak.jdField_a_of_type_Bbzp).b)));
      a((bbzo)parambcak.jdField_a_of_type_Bbzp);
      return;
      h((bbzo)parambcak.jdField_a_of_type_Bbzp);
      parambcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambcak.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bcam.a(parambcak);
    } while ((this.jdField_a_of_type_Bbzo == null) || (!this.jdField_a_of_type_Bbzo.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bbzo.jdField_c_of_type_Int != ((bbzo)parambcak.jdField_a_of_type_Bbzp).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Bbzo);
  }
  
  public void a(bbzo parambbzo)
  {
    if (this.b)
    {
      if (parambbzo.jdField_a_of_type_Boolean)
      {
        b(parambbzo);
        return;
      }
      b(this.jdField_a_of_type_Bbzo);
      c(parambbzo);
      return;
    }
    c(parambbzo);
  }
  
  public void a(bcak parambcak, bbzo parambbzo, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambcak.b.setVisibility(4);
      parambcak.c.setVisibility(4);
    }
    for (;;)
    {
      parambcak.jdField_a_of_type_AndroidWidgetTextView.setText(parambbzo.jdField_a_of_type_Int + "\"");
      if (!parambbzo.jdField_a_of_type_Boolean) {
        break;
      }
      parambbzo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772263);
      parambcak.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambbzo);
      parambbzo.start();
      return;
      parambcak.b.setVisibility(0);
      switch (parambbzo.g)
      {
      default: 
        break;
      case 0: 
        parambcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcak.c.setVisibility(4);
        break;
      case 1: 
        parambcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcak.c.setVisibility(4);
        break;
      case 2: 
        parambcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcak.c.setVisibility(0);
        break;
      case 3: 
        parambcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambcak.c.setVisibility(4);
      }
    }
    parambcak.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846506);
  }
  
  public void b(bbzo parambbzo)
  {
    bcak localbcak;
    if ((parambbzo != null) && (parambbzo.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bdks.f();
      this.jdField_a_of_type_Bdks = null;
      parambbzo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bbzo = null;
      localbcak = (bcak)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambbzo.jdField_c_of_type_Int);
      if (localbcak != null)
      {
        if (!parambbzo.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambbzo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772263);
        localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambbzo);
        parambbzo.start();
      }
    }
    return;
    label93:
    localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846506);
  }
  
  public void c(bbzo parambbzo)
  {
    if ((!TextUtils.isEmpty(parambbzo.jdField_a_of_type_JavaLangString)) && (new File(parambbzo.jdField_a_of_type_JavaLangString).exists())) {
      g(parambbzo);
    }
    while (TextUtils.isEmpty(parambbzo.b)) {
      return;
    }
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694061), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambbzo), 8, null, true);
  }
  
  public void d(bbzo parambbzo)
  {
    e(parambbzo);
  }
  
  public void e(bbzo parambbzo)
  {
    if ((!TextUtils.isEmpty(parambbzo.b)) || (parambbzo.g != 0)) {
      return;
    }
    h(parambbzo);
  }
  
  public void f(bbzo parambbzo)
  {
    if ((TextUtils.isEmpty(parambbzo.b)) && (parambbzo.g == 1)) {
      h(parambbzo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcag
 * JD-Core Version:    0.7.0.1
 */