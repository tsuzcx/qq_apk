import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bgah
  extends amgf
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final bfzp jdField_a_of_type_Bfzp;
  bfzw jdField_a_of_type_Bfzw;
  private final bgae jdField_a_of_type_Bgae;
  private bgak jdField_a_of_type_Bgak;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<ajvr, bfzy> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<ajvr> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bgah(bgae parambgae, TroopChatPie paramTroopChatPie)
  {
    super(parambgae.jdField_a_of_type_AndroidContentContext, parambgae.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambgae.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambgae.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambgae.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Bgae = parambgae;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Bfzp = new bfzp(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bgak = new bgak(this);
    d();
  }
  
  private void a(int paramInt, bgaj parambgaj)
  {
    ajvr localajvr = (ajvr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambgaj.c.setImageBitmap(a(localajvr.jdField_a_of_type_JavaLangString, 2));
    Object localObject = bfzz.b(localajvr);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localajvr.v;
    }
    localObject = new begq((CharSequence)localObject, 16).a();
    parambgaj.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bhmb.a(parambgaj.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject, localajvr.jdField_a_of_type_Int);
    parambgaj.jdField_a_of_type_JavaLangString = localajvr.jdField_a_of_type_JavaLangString;
    parambgaj.jdField_a_of_type_Int = paramInt;
    bgaj.a(parambgaj).setTag(parambgaj);
    bgaj.a(parambgaj).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambgaj, localajvr);
    c(parambgaj, localajvr);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localajvr))
    {
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bgak.jdField_a_of_type_Boolean) {
        break label210;
      }
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambgaj, localajvr);
      b(parambgaj, localajvr);
      return;
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label210:
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(ajvr paramajvr)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((ajvr)((Map.Entry)localObject1).getKey()).equals(paramajvr)) {
        localObject1 = (bfzy)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramajvr = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramajvr.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramajvr.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (bfzy)localEntry.getValue();
        int m = ((bfzy)localObject2).jdField_a_of_type_Int - ((bfzy)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bfzy(k, ((bfzy)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bgaj)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bgak.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bgak.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bfzp.b();
    } while (!this.jdField_a_of_type_Bfzp.a());
    ajvr localajvr = (ajvr)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localajvr);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfzp.a();
      if ((this.jdField_a_of_type_Bgak.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfzw == null)) {
        break;
      }
      this.jdField_a_of_type_Bfzw.a();
      return;
      b(localajvr);
      a(localajvr);
      break label79;
    }
  }
  
  private void a(bgaj parambgaj)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bfzp.a(parambgaj.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambgaj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin();
    this.jdField_a_of_type_Bfzp.a((String)localObject);
    this.jdField_a_of_type_Bgak.a(parambgaj.c);
    localObject = (ajvr)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bgak.jdField_a_of_type_Boolean)
    {
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambgaj.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bgaj parambgaj, ajvr paramajvr)
  {
    if (parambgaj.jdField_a_of_type_AndroidViewView != null)
    {
      bgls localbgls = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localbgls == null) || (!localbgls.b(paramajvr.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambgaj.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambgaj.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(ajvr paramajvr)
  {
    paramajvr = (bfzy)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramajvr);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getEditableText();
    if (paramajvr != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramajvr);
      }
      int i = paramajvr.jdField_a_of_type_Int;
      int j = paramajvr.jdField_a_of_type_Int;
      localEditable.delete(i, paramajvr.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bgaj)paramView.getTag();
    paramView = ((bgaj)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    ajvr localajvr = (ajvr)getItem(((bgaj)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bgak.a())
      {
        this.jdField_a_of_type_Bgak.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localajvr);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if (((this.jdField_a_of_type_Bfzw != null) && (paramView.b(localajvr.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Bfzw != null) && (!this.jdField_a_of_type_Bgak.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Bfzw.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localajvr.v)) || (!localajvr.v.equals(localajvr.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localajvr);
      a(localajvr);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localajvr.v))
      {
        paramView = (View)localObject;
        if (localajvr.v.equals(localajvr.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bgaj parambgaj, ajvr paramajvr)
  {
    if (parambgaj.b != null)
    {
      if (paramajvr.jdField_a_of_type_Boolean)
      {
        paramajvr = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambgaj.b.setBackgroundDrawable(paramajvr);
        parambgaj.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambgaj.b.setVisibility(8);
  }
  
  private void c(ajvr paramajvr)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramajvr)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramajvr });
    }
    Object localObject;
    do
    {
      return;
      localObject = bfzz.a(paramajvr);
      localObject = bgcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, paramajvr.jdField_a_of_type_JavaLangString, (String)localObject, bfzz.a(paramajvr), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (bfzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bfzy localbfzy = new bfzy(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramajvr, localbfzy);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbfzy, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bgaj parambgaj, ajvr paramajvr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramajvr.jdField_a_of_type_JavaLangString))
    {
      bgaj.a(parambgaj).setVisibility(0);
      paramajvr = bfkd.a().a(true, false);
      bgaj.a(parambgaj).setText(paramajvr.jdField_a_of_type_JavaLangString);
      paramajvr = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajvr.b);
      bgaj.a(parambgaj).setBackgroundDrawable(paramajvr);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopAdmin(paramajvr.jdField_a_of_type_JavaLangString))
    {
      bgaj.a(parambgaj).setVisibility(0);
      paramajvr = bfkd.a().a(false, true);
      bgaj.a(parambgaj).setText(paramajvr.jdField_a_of_type_JavaLangString);
      paramajvr = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajvr.b);
      bgaj.a(parambgaj).setBackgroundDrawable(paramajvr);
      return;
    }
    bgaj.a(parambgaj).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bgai(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  ajvr a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ajvr localajvr = (ajvr)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localajvr.jdField_a_of_type_JavaLangString != null) && (localajvr.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localajvr;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bgak a()
  {
    return this.jdField_a_of_type_Bgak;
  }
  
  public List<ajvr> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(bfzw parambfzw)
  {
    this.jdField_a_of_type_Bfzw = parambfzw;
  }
  
  public void a(bgam parambgam)
  {
    this.jdField_a_of_type_JavaUtilList = parambgam.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambgam.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambgam.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambgam.jdField_a_of_type_JavaLangString;
    this.b = parambgam.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bfzp.a();
    if (TextUtils.isEmpty(parambgam.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    for (;;)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public void a(List<ajvr> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return "0".equals(((ajvr)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i != 1) {
        break label72;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bgak.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfzp != null) {
      this.jdField_a_of_type_Bfzp.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (a())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    label37:
    bgaj localbgaj;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563000, paramViewGroup, false);
      localbgaj = new bgaj(paramView);
      paramView.setTag(localbgaj);
      label53:
      if (i == 0) {
        break label117;
      }
      a(localbgaj);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562999, paramViewGroup, false);
      break label37;
      label105:
      localbgaj = (bgaj)paramView.getTag();
      break label53;
      label117:
      a(paramInt, localbgaj);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgah
 * JD-Core Version:    0.7.0.1
 */