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

public class bfgc
  extends bffo
{
  protected String b;
  protected Map<bfex, Stream<bfex>> b;
  
  public bfgc(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bfgf a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560608, paramViewGroup, false);
    bfgf localbfgf = new bfgf(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbfgf.hashCode()) });
    }
    b(localbfgf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbfgf);
    b(localbfgf.jdField_a_of_type_AndroidWidgetImageView, localbfgf);
    b(localbfgf.b, localbfgf);
    b(localbfgf.c, localbfgf);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbfgf;
  }
  
  protected SimpleObserver<bfer> a(bfer parambfer)
  {
    return new bfgd(this, parambfer);
  }
  
  protected SimpleObserver<bfex> a(bfex parambfex)
  {
    return new bfge(this, parambfex);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bfex)localIterator.next();
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
        localObject = (bfex)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((bfex)localObject).c), ", type=", Integer.valueOf(((bfex)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((bfex)localObject).d;
      ((bfex)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((bfex)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bffs parambffs)
  {
    bfex localbfex = (bfex)parambffs.jdField_a_of_type_Bfem;
    switch (paramView.getId())
    {
    case 2131368022: 
    default: 
    case 2131368019: 
    case 2131368023: 
      do
      {
        return;
        this.jdField_a_of_type_Bffj.a(parambffs);
        return;
      } while (localbfex.g != 2);
      parambffs.b.setVisibility(4);
      a(localbfex);
      return;
    }
    bkft.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbfex.c), ", path=", localbfex.f });
    }
    a(localbfex);
  }
  
  protected void a(bfer parambfer)
  {
    parambfer = (bfex)parambfer;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambfer.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambfer))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambfer, localStream1);
    }
    Stream localStream2 = parambfer.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambfer)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambfer, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambfer.d;
        parambfer.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambfer));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambfer.d;
    this.jdField_a_of_type_Boolean = true;
    parambfer.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambfer));
  }
  
  public void a(bfex parambfex)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambfex.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambfex = new Intent();
    parambfex.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambfex.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambfex);
  }
  
  protected void a(bffs parambffs, bfer parambfer, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambffs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambffs.c.setVisibility(0);
      parambffs.b.setVisibility(4);
      parambffs.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambffs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambfer.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambffs.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambffs.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambffs.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambfer.e, parambfer.d);
        parambffs.b.setVisibility(4);
        parambffs.c.setVisibility(4);
        return;
      }
    } while (parambfer.e != 100);
    parambffs.a();
    return;
    parambffs.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambffs.b.setVisibility(0);
    parambffs.c.setVisibility(4);
  }
  
  public void d(bfem parambfem)
  {
    super.d(parambfem);
    parambfem = (bfex)parambfem;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambfem = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambfem);
      if (parambfem != null) {
        parambfem.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgc
 * JD-Core Version:    0.7.0.1
 */