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

public class bepe
  extends beoq
{
  protected String b;
  protected Map<benz, Stream<benz>> b;
  
  public bepe(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public beph a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560633, paramViewGroup, false);
    beph localbeph = new beph(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbeph.hashCode()) });
    }
    b(localbeph.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbeph);
    b(localbeph.jdField_a_of_type_AndroidWidgetImageView, localbeph);
    b(localbeph.b, localbeph);
    b(localbeph.c, localbeph);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbeph;
  }
  
  protected SimpleObserver<bent> a(bent parambent)
  {
    return new bepf(this, parambent);
  }
  
  protected SimpleObserver<benz> a(benz parambenz)
  {
    return new bepg(this, parambenz);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (benz)localIterator.next();
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
        localObject = (benz)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((benz)localObject).c), ", type=", Integer.valueOf(((benz)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((benz)localObject).d;
      ((benz)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((benz)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, beou parambeou)
  {
    benz localbenz = (benz)parambeou.jdField_a_of_type_Beno;
    switch (paramView.getId())
    {
    case 2131368125: 
    default: 
    case 2131368122: 
    case 2131368126: 
      do
      {
        return;
        this.jdField_a_of_type_Beol.a(parambeou);
        return;
      } while (localbenz.g != 2);
      parambeou.b.setVisibility(4);
      a(localbenz);
      return;
    }
    bjmm.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbenz.c), ", path=", localbenz.f });
    }
    a(localbenz);
  }
  
  protected void a(bent parambent)
  {
    parambent = (benz)parambent;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambent.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambent))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambent, localStream1);
    }
    Stream localStream2 = parambent.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambent)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambent, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambent.d;
        parambent.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambent));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambent.d;
    this.jdField_a_of_type_Boolean = true;
    parambent.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambent));
  }
  
  public void a(benz parambenz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambenz.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambenz = new Intent();
    parambenz.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambenz.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambenz);
  }
  
  protected void a(beou parambeou, bent parambent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambeou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambeou.c.setVisibility(0);
      parambeou.b.setVisibility(4);
      parambeou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambeou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambent.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambeou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambeou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambeou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambent.e, parambent.d);
        parambeou.b.setVisibility(4);
        parambeou.c.setVisibility(4);
        return;
      }
    } while (parambent.e != 100);
    parambeou.a();
    return;
    parambeou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambeou.b.setVisibility(0);
    parambeou.c.setVisibility(4);
  }
  
  public void d(beno parambeno)
  {
    super.d(parambeno);
    parambeno = (benz)parambeno;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambeno = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambeno);
      if (parambeno != null) {
        parambeno.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepe
 * JD-Core Version:    0.7.0.1
 */