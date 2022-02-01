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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
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

public class bgjt
  extends amnl
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final bgjb jdField_a_of_type_Bgjb;
  bgji jdField_a_of_type_Bgji;
  private final bgjq jdField_a_of_type_Bgjq;
  private bgjw jdField_a_of_type_Bgjw;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<akfc, bgjk> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<akfc> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bgjt(bgjq parambgjq, TroopChatPie paramTroopChatPie)
  {
    super(parambgjq.jdField_a_of_type_AndroidContentContext, parambgjq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambgjq.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambgjq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambgjq.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Bgjq = parambgjq;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Bgjb = new bgjb(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bgjw = new bgjw(this);
    d();
  }
  
  private void a(int paramInt, bgjv parambgjv)
  {
    akfc localakfc = (akfc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambgjv.c.setImageBitmap(a(localakfc.jdField_a_of_type_JavaLangString, 2));
    Object localObject = bgjl.b(localakfc);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localakfc.v;
    }
    localObject = new begb((CharSequence)localObject, 16).a();
    parambgjv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bhwz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambgjv.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambgjv.jdField_a_of_type_JavaLangString = localakfc.jdField_a_of_type_JavaLangString;
    parambgjv.jdField_a_of_type_Int = paramInt;
    bgjv.a(parambgjv).setTag(parambgjv);
    bgjv.a(parambgjv).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambgjv, localakfc);
    c(parambgjv, localakfc);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localakfc))
    {
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bgjw.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambgjv, localakfc);
      b(parambgjv, localakfc);
      return;
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(akfc paramakfc)
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
      if (((akfc)((Map.Entry)localObject1).getKey()).equals(paramakfc)) {
        localObject1 = (bgjk)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramakfc = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramakfc.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramakfc.next();
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
        localObject2 = (bgjk)localEntry.getValue();
        int m = ((bgjk)localObject2).jdField_a_of_type_Int - ((bgjk)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bgjk(k, ((bgjk)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bgjv)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bgjw.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bgjw.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bgjb.b();
    } while (!this.jdField_a_of_type_Bgjb.a());
    akfc localakfc = (akfc)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localakfc);
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
      this.jdField_a_of_type_Bgjb.a();
      if ((this.jdField_a_of_type_Bgjw.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bgji == null)) {
        break;
      }
      this.jdField_a_of_type_Bgji.a();
      return;
      b(localakfc);
      a(localakfc);
      break label79;
    }
  }
  
  private void a(bgjv parambgjv)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bgjb.a(parambgjv.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambgjv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Bgjb.a((String)localObject);
    this.jdField_a_of_type_Bgjw.a(parambgjv.c);
    localObject = (akfc)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bgjw.jdField_a_of_type_Boolean)
    {
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambgjv.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bgjv parambgjv, akfc paramakfc)
  {
    if (parambgjv.jdField_a_of_type_AndroidViewView != null)
    {
      bgty localbgty = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbgty == null) || (!localbgty.b(paramakfc.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambgjv.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambgjv.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(akfc paramakfc)
  {
    paramakfc = (bgjk)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramakfc);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramakfc != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramakfc);
      }
      int i = paramakfc.jdField_a_of_type_Int;
      int j = paramakfc.jdField_a_of_type_Int;
      localEditable.delete(i, paramakfc.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bgjv)paramView.getTag();
    paramView = ((bgjv)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    akfc localakfc = (akfc)getItem(((bgjv)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bgjw.a())
      {
        this.jdField_a_of_type_Bgjw.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localakfc);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Bgji != null) && (paramView.b(localakfc.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Bgji != null) && (!this.jdField_a_of_type_Bgjw.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Bgji.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localakfc.v)) || (!localakfc.v.equals(localakfc.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localakfc);
      a(localakfc);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localakfc.v))
      {
        paramView = (View)localObject;
        if (localakfc.v.equals(localakfc.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bgjv parambgjv, akfc paramakfc)
  {
    if (parambgjv.b != null)
    {
      if (paramakfc.jdField_a_of_type_Boolean)
      {
        paramakfc = bguq.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambgjv.b.setBackgroundDrawable(paramakfc);
        parambgjv.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambgjv.b.setVisibility(8);
  }
  
  private void c(akfc paramakfc)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramakfc)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramakfc });
    }
    Object localObject;
    do
    {
      return;
      localObject = bgjl.a(paramakfc);
      localObject = bgme.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramakfc.jdField_a_of_type_JavaLangString, (String)localObject, bgjl.a(paramakfc), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (bgjl.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bgjk localbgjk = new bgjk(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramakfc, localbgjk);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbgjk, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bgjv parambgjv, akfc paramakfc)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramakfc.jdField_a_of_type_JavaLangString))
    {
      bgjv.a(parambgjv).setVisibility(0);
      paramakfc = bftp.a().a(true, false);
      bgjv.a(parambgjv).setText(paramakfc.jdField_a_of_type_JavaLangString);
      paramakfc = bguq.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramakfc.b);
      bgjv.a(parambgjv).setBackgroundDrawable(paramakfc);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramakfc.jdField_a_of_type_JavaLangString))
    {
      bgjv.a(parambgjv).setVisibility(0);
      paramakfc = bftp.a().a(false, true);
      bgjv.a(parambgjv).setText(paramakfc.jdField_a_of_type_JavaLangString);
      paramakfc = bguq.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramakfc.b);
      bgjv.a(parambgjv).setBackgroundDrawable(paramakfc);
      return;
    }
    bgjv.a(parambgjv).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bgjq.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bgju(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Bgjq.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
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
  
  akfc a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        akfc localakfc = (akfc)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localakfc.jdField_a_of_type_JavaLangString != null) && (localakfc.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localakfc;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bgjw a()
  {
    return this.jdField_a_of_type_Bgjw;
  }
  
  public List<akfc> a()
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
    paramView = this.jdField_a_of_type_Bgjq.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(bgji parambgji)
  {
    this.jdField_a_of_type_Bgji = parambgji;
  }
  
  public void a(bgjy parambgjy)
  {
    this.jdField_a_of_type_JavaUtilList = parambgjy.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambgjy.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambgjy.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambgjy.jdField_a_of_type_JavaLangString;
    this.b = parambgjy.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bgjb.a();
    if (TextUtils.isEmpty(parambgjy.jdField_a_of_type_JavaLangString))
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
  
  public void a(List<akfc> paramList)
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
    return "0".equals(((akfc)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bgjw.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bgjb != null) {
      this.jdField_a_of_type_Bgjb.c();
    }
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
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
    bgjv localbgjv;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563045, paramViewGroup, false);
      localbgjv = new bgjv(paramView);
      paramView.setTag(localbgjv);
      label53:
      if (i == 0) {
        break label117;
      }
      a(localbgjv);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563044, paramViewGroup, false);
      break label37;
      label105:
      localbgjv = (bgjv)paramView.getTag();
      break label53;
      label117:
      a(paramInt, localbgjv);
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
 * Qualified Name:     bgjt
 * JD-Core Version:    0.7.0.1
 */