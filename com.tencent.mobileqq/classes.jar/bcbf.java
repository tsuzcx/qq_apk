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

public class bcbf
  extends bcar
{
  protected String b;
  protected Map<bcaa, Stream<bcaa>> b;
  
  public bcbf(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bcbi a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560454, paramViewGroup, false);
    bcbi localbcbi = new bcbi(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbcbi.hashCode()) });
    }
    b(localbcbi.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbcbi);
    b(localbcbi.jdField_a_of_type_AndroidWidgetImageView, localbcbi);
    b(localbcbi.b, localbcbi);
    b(localbcbi.c, localbcbi);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbcbi;
  }
  
  protected SimpleObserver<bbzu> a(bbzu parambbzu)
  {
    return new bcbg(this, parambbzu);
  }
  
  protected SimpleObserver<bcaa> a(bcaa parambcaa)
  {
    return new bcbh(this, parambcaa);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bcaa)localIterator.next();
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
        localObject = (bcaa)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((bcaa)localObject).c), ", type=", Integer.valueOf(((bcaa)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((bcaa)localObject).d;
      ((bcaa)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((bcaa)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bcav parambcav)
  {
    bcaa localbcaa = (bcaa)parambcav.jdField_a_of_type_Bbzp;
    switch (paramView.getId())
    {
    case 2131367700: 
    default: 
    case 2131367697: 
    case 2131367701: 
      do
      {
        return;
        this.jdField_a_of_type_Bcam.a(parambcav);
        return;
      } while (localbcaa.g != 2);
      parambcav.b.setVisibility(4);
      a(localbcaa);
      return;
    }
    bhoc.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbcaa.c), ", path=", localbcaa.f });
    }
    a(localbcaa);
  }
  
  protected void a(bbzu parambbzu)
  {
    parambbzu = (bcaa)parambbzu;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambbzu.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambbzu))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambbzu, localStream1);
    }
    Stream localStream2 = parambbzu.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambbzu)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambbzu, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambbzu.d;
        parambbzu.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambbzu));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambbzu.d;
    this.jdField_a_of_type_Boolean = true;
    parambbzu.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambbzu));
  }
  
  public void a(bcaa parambcaa)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambcaa.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambcaa = new Intent();
    parambcaa.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambcaa.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambcaa);
  }
  
  protected void a(bcav parambcav, bbzu parambbzu, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambcav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambcav.c.setVisibility(0);
      parambcav.b.setVisibility(4);
      parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambcav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambbzu.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambbzu.e, parambbzu.d);
        parambcav.b.setVisibility(4);
        parambcav.c.setVisibility(4);
        return;
      }
    } while (parambbzu.e != 100);
    parambcav.a();
    return;
    parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambcav.b.setVisibility(0);
    parambcav.c.setVisibility(4);
  }
  
  public void d(bbzp parambbzp)
  {
    super.d(parambbzp);
    parambbzp = (bcaa)parambbzp;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambbzp = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambbzp);
      if (parambbzp != null) {
        parambbzp.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbf
 * JD-Core Version:    0.7.0.1
 */