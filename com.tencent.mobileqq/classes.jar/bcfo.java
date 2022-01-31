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

public class bcfo
  extends bcfa
{
  protected String b;
  protected Map<bcej, Stream<bcej>> b;
  
  public bcfo(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bcfr a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560453, paramViewGroup, false);
    bcfr localbcfr = new bcfr(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbcfr.hashCode()) });
    }
    b(localbcfr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbcfr);
    b(localbcfr.jdField_a_of_type_AndroidWidgetImageView, localbcfr);
    b(localbcfr.b, localbcfr);
    b(localbcfr.c, localbcfr);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbcfr;
  }
  
  protected SimpleObserver<bced> a(bced parambced)
  {
    return new bcfp(this, parambced);
  }
  
  protected SimpleObserver<bcej> a(bcej parambcej)
  {
    return new bcfq(this, parambcej);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bcej)localIterator.next();
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
        localObject = (bcej)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((bcej)localObject).c), ", type=", Integer.valueOf(((bcej)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((bcej)localObject).d;
      ((bcej)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((bcej)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bcfe parambcfe)
  {
    bcej localbcej = (bcej)parambcfe.jdField_a_of_type_Bcdy;
    switch (paramView.getId())
    {
    case 2131367710: 
    default: 
    case 2131367707: 
    case 2131367711: 
      do
      {
        return;
        this.jdField_a_of_type_Bcev.a(parambcfe);
        return;
      } while (localbcej.g != 2);
      parambcfe.b.setVisibility(4);
      a(localbcej);
      return;
    }
    bhsj.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbcej.c), ", path=", localbcej.f });
    }
    a(localbcej);
  }
  
  protected void a(bced parambced)
  {
    parambced = (bcej)parambced;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambced.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambced))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambced, localStream1);
    }
    Stream localStream2 = parambced.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambced)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambced, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambced.d;
        parambced.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambced));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambced.d;
    this.jdField_a_of_type_Boolean = true;
    parambced.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambced));
  }
  
  public void a(bcej parambcej)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambcej.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambcej = new Intent();
    parambcej.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambcej.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambcej);
  }
  
  protected void a(bcfe parambcfe, bced parambced, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambcfe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambcfe.c.setVisibility(0);
      parambcfe.b.setVisibility(4);
      parambcfe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambcfe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambced.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambcfe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambcfe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambcfe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambced.e, parambced.d);
        parambcfe.b.setVisibility(4);
        parambcfe.c.setVisibility(4);
        return;
      }
    } while (parambced.e != 100);
    parambcfe.a();
    return;
    parambcfe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambcfe.b.setVisibility(0);
    parambcfe.c.setVisibility(4);
  }
  
  public void d(bcdy parambcdy)
  {
    super.d(parambcdy);
    parambcdy = (bcej)parambcdy;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambcdy = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambcdy);
      if (parambcdy != null) {
        parambcdy.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfo
 * JD-Core Version:    0.7.0.1
 */