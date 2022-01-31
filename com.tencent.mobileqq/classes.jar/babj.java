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

public class babj
  extends bach<babn, baar>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new babl(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private baar jdField_a_of_type_Baar;
  private bblk jdField_a_of_type_Bblk;
  private bbll jdField_a_of_type_Bbll = new babk(this);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public babj(XMediaEditor paramXMediaEditor, Context paramContext)
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
  
  private void g(baar parambaar)
  {
    if (this.b) {}
    babn localbabn;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Baar = parambaar;
      parambaar.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bblk = new bblk(parambaar.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_Bblk.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bblk.b();
      this.jdField_a_of_type_Bblk.a(this.jdField_a_of_type_Bbll);
      this.jdField_a_of_type_Bblk.c();
      localbabn = (babn)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambaar.jdField_c_of_type_Int);
    } while (localbabn == null);
    if (parambaar.jdField_a_of_type_Boolean)
    {
      parambaar = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambaar);
      parambaar.start();
      return;
    }
    localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846121);
  }
  
  private void h(baar parambaar)
  {
    bhws localbhws = new bhws(tsu.a(), parambaar.jdField_a_of_type_JavaLangString, parambaar.jdField_c_of_type_JavaLangString);
    localbhws.a(new babm(this, parambaar));
    parambaar.g = 1;
    ThreadManager.post(new AudioItem.2(this, localbhws), 8, null, true);
  }
  
  public babn a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new babn(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561144, paramViewGroup, false));
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
      b(this.jdField_a_of_type_Baar);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, babn parambabn)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((baar)parambabn.jdField_a_of_type_Baas).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((baar)parambabn.jdField_a_of_type_Baas).b)));
      a((baar)parambabn.jdField_a_of_type_Baas);
      return;
      h((baar)parambabn.jdField_a_of_type_Baas);
      parambabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambabn.c.setVisibility(4);
      return;
      this.jdField_a_of_type_Babp.a(parambabn);
    } while ((this.jdField_a_of_type_Baar == null) || (!this.jdField_a_of_type_Baar.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Baar.jdField_c_of_type_Int != ((baar)parambabn.jdField_a_of_type_Baas).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_Baar);
  }
  
  public void a(baar parambaar)
  {
    if (this.b)
    {
      if (parambaar.jdField_a_of_type_Boolean)
      {
        b(parambaar);
        return;
      }
      b(this.jdField_a_of_type_Baar);
      c(parambaar);
      return;
    }
    c(parambaar);
  }
  
  public void a(babn parambabn, baar parambaar, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambabn.b.setVisibility(4);
      parambabn.c.setVisibility(4);
    }
    for (;;)
    {
      parambabn.jdField_a_of_type_AndroidWidgetTextView.setText(parambaar.jdField_a_of_type_Int + "\"");
      if (!parambaar.jdField_a_of_type_Boolean) {
        break;
      }
      parambaar = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
      parambabn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambaar);
      parambaar.start();
      return;
      parambabn.b.setVisibility(0);
      switch (parambaar.g)
      {
      default: 
        break;
      case 0: 
        parambabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambabn.c.setVisibility(4);
        break;
      case 1: 
        parambabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambabn.c.setVisibility(4);
        break;
      case 2: 
        parambabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        parambabn.c.setVisibility(0);
        break;
      case 3: 
        parambabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambabn.c.setVisibility(4);
      }
    }
    parambabn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846121);
  }
  
  public void b(baar parambaar)
  {
    babn localbabn;
    if ((parambaar != null) && (parambaar.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_Bblk.f();
      this.jdField_a_of_type_Bblk = null;
      parambaar.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Baar = null;
      localbabn = (babn)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(parambaar.jdField_c_of_type_Int);
      if (localbabn != null)
      {
        if (!parambaar.jdField_a_of_type_Boolean) {
          break label93;
        }
        parambaar = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772249);
        localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambaar);
        parambaar.start();
      }
    }
    return;
    label93:
    localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846121);
  }
  
  public void c(baar parambaar)
  {
    if ((!TextUtils.isEmpty(parambaar.jdField_a_of_type_JavaLangString)) && (new File(parambaar.jdField_a_of_type_JavaLangString).exists())) {
      g(parambaar);
    }
    while (TextUtils.isEmpty(parambaar.b)) {
      return;
    }
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131693944), 0).a();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, parambaar), 8, null, true);
  }
  
  public void d(baar parambaar)
  {
    e(parambaar);
  }
  
  public void e(baar parambaar)
  {
    if ((!TextUtils.isEmpty(parambaar.b)) || (parambaar.g != 0)) {
      return;
    }
    h(parambaar);
  }
  
  public void f(baar parambaar)
  {
    if ((TextUtils.isEmpty(parambaar.b)) && (parambaar.g == 1)) {
      h(parambaar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babj
 * JD-Core Version:    0.7.0.1
 */