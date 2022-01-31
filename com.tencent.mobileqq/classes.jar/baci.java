import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class baci
  extends babu
{
  protected String b;
  protected Map<babd, Stream<babd>> b;
  
  public baci(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bacl a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560346, paramViewGroup, false);
    bacl localbacl = new bacl(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbacl.hashCode()) });
    }
    b(localbacl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbacl);
    b(localbacl.jdField_a_of_type_AndroidWidgetImageView, localbacl);
    b(localbacl.b, localbacl);
    b(localbacl.c, localbacl);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbacl;
  }
  
  protected SimpleObserver<baax> a(baax parambaax)
  {
    return new bacj(this, parambaax);
  }
  
  protected SimpleObserver<babd> a(babd parambabd)
  {
    return new back(this, parambabd);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (babd)localIterator.next();
        localObject = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      super.a(paramInt, paramBoolean);
    }
    do
    {
      Object localObject;
      Stream localStream;
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        localObject = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
        }
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localObject = (babd)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((babd)localObject).c), ", type=", Integer.valueOf(((babd)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((babd)localObject).d;
      ((babd)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((babd)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, baby parambaby)
  {
    babd localbabd = (babd)parambaby.jdField_a_of_type_Baas;
    switch (paramView.getId())
    {
    case 2131367571: 
    default: 
    case 2131367568: 
    case 2131367572: 
      do
      {
        return;
        this.jdField_a_of_type_Babp.a(parambaby);
        return;
      } while (localbabd.g != 2);
      parambaby.b.setVisibility(4);
      a(localbabd);
      return;
    }
    bfmr.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbabd.c), ", path=", localbabd.f });
    }
    a(localbabd);
  }
  
  protected void a(baax parambaax)
  {
    parambaax = (babd)parambaax;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambaax.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambaax))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambaax, localStream1);
    }
    Stream localStream2 = parambaax.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambaax)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambaax, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambaax.d;
        parambaax.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambaax));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambaax.d;
    this.jdField_a_of_type_Boolean = true;
    parambaax.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambaax));
  }
  
  public void a(babd parambabd)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambabd.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambabd = new Intent();
    parambabd.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambabd.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambabd);
  }
  
  protected void a(baby parambaby, baax parambaax, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambaby.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambaby.c.setVisibility(0);
      parambaby.b.setVisibility(4);
      parambaby.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambaby.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambaax.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambaby.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambaby.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambaby.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambaax.e, parambaax.d);
        parambaby.b.setVisibility(4);
        parambaby.c.setVisibility(4);
        return;
      }
    } while (parambaax.e != 100);
    parambaby.a();
    return;
    parambaby.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambaby.b.setVisibility(0);
    parambaby.c.setVisibility(4);
  }
  
  public void d(baas parambaas)
  {
    super.d(parambaas);
    parambaas = (babd)parambaas;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambaas = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambaas);
      if (parambaas != null) {
        parambaas.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baci
 * JD-Core Version:    0.7.0.1
 */