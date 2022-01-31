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

public class bcep
  extends bcfn<bcet, bcdx>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bcer(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bcdx jdField_a_of_type_Bcdx;
  private bdpb jdField_a_of_type_Bdpb;
  private bdpc jdField_a_of_type_Bdpc = new bceq(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bcep(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(bcdx parambcdx)
  {
    if (this.b) {}
    bcet localbcet;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Bcdx = parambcdx;
      parambcdx.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bdpb = new bdpb(parambcdx.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bdpb.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bdpb.b();
      this.jdField_a_of_type_Bdpb.a(this.jdField_a_of_type_Bdpc);
      this.jdField_a_of_type_Bdpb.c();
      localbcet = (bcet)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambcdx.jdField_c_of_type_Int);
    } while (localbcet == null);
    if (parambcdx.jdField_a_of_type_Boolean)
    {
      parambcdx = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772264);
      localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambcdx);
      parambcdx.start();
      return;
    }
    localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846579);
  }
  
  private void h(bcdx parambcdx)
  {
    bkdb localbkdb = new bkdb(vls.a(), parambcdx.jdField_a_of_type_JavaLangString, parambcdx.jdField_c_of_type_JavaLangString);
    localbkdb.a(new bces(this, parambcdx));
    parambcdx.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbkdb), 8, null, true);
  }
  
  public bcet a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bcet(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561349, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Bcdx);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, bcet parambcet)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((bcdx)parambcet.jdField_a_of_type_Bcdy).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((bcdx)parambcet.jdField_a_of_type_Bcdy).b)));
      a((bcdx)parambcet.jdField_a_of_type_Bcdy);
      return;
      h((bcdx)parambcet.jdField_a_of_type_Bcdy);
      parambcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambcet.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Bcev.a(parambcet);
    } while ((this.jdField_a_of_type_Bcdx == null) || (!this.jdField_a_of_type_Bcdx.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bcdx.jdField_c_of_type_Int != ((bcdx)parambcet.jdField_a_of_type_Bcdy).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Bcdx);
  }
  
  public void a(bcdx parambcdx)
  {
    if (this.b)
    {
      if (parambcdx.jdField_a_of_type_Boolean)
      {
        b(parambcdx);
        return;
      }
      b(this.jdField_a_of_type_Bcdx);
      c(parambcdx);
      return;
    }
    c(parambcdx);
  }
  
  public void a(bcet parambcet, bcdx parambcdx, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambcet.b.setVisibility(4);
      parambcet.c.setVisibility(4);
    }
    for (;;)
    {
      parambcet.jdField_a_of_type_AndroidWidgetTextView.setText(parambcdx.jdField_a_of_type_Int + "\"");
      if (!parambcdx.jdField_a_of_type_Boolean) {
        break;
      }
      parambcdx = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772264);
      parambcet.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambcdx);
      parambcdx.start();
      return;
      parambcet.b.setVisibility(0);
      switch (parambcdx.g)
      {
      default: 
        break;
      case 0: 
        parambcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcet.c.setVisibility(4);
        break;
      case 1: 
        parambcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcet.c.setVisibility(4);
        break;
      case 2: 
        parambcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambcet.c.setVisibility(0);
        break;
      case 3: 
        parambcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambcet.c.setVisibility(4);
      }
    }
    parambcet.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846579);
  }
  
  public void b(bcdx parambcdx)
  {
    bcet localbcet;
    if ((parambcdx != null) && (parambcdx.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bdpb.f();
      this.jdField_a_of_type_Bdpb = null;
      parambcdx.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bcdx = null;
      localbcet = (bcet)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambcdx.jdField_c_of_type_Int);
      if (localbcet != null)
      {
        if (!parambcdx.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambcdx = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772264);
        localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambcdx);
        parambcdx.start();
      }
    }
    return;
    label93:
    localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846579);
  }
  
  public void c(bcdx parambcdx)
  {
    if ((!TextUtils.isEmpty(parambcdx.jdField_a_of_type_JavaLangString)) && (new File(parambcdx.jdField_a_of_type_JavaLangString).exists())) {
      g(parambcdx);
    }
    while (TextUtils.isEmpty(parambcdx.b)) {
      return;
    }
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694063), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambcdx), 8, null, true);
  }
  
  public void d(bcdx parambcdx)
  {
    e(parambcdx);
  }
  
  public void e(bcdx parambcdx)
  {
    if ((!TextUtils.isEmpty(parambcdx.b)) || (parambcdx.g != 0)) {
      return;
    }
    h(parambcdx);
  }
  
  public void f(bcdx parambcdx)
  {
    if ((TextUtils.isEmpty(parambcdx.b)) && (parambcdx.g == 1)) {
      h(parambcdx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcep
 * JD-Core Version:    0.7.0.1
 */