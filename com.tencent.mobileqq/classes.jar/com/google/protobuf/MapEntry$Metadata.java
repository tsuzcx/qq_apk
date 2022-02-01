package com.google.protobuf;

final class MapEntry$Metadata<K, V>
  extends MapEntryLite.Metadata<K, V>
{
  public final Descriptors.Descriptor a;
  public final Parser<MapEntry<K, V>> b;
  
  public MapEntry$Metadata(Descriptors.Descriptor paramDescriptor, MapEntry<K, V> paramMapEntry, WireFormat.FieldType paramFieldType1, WireFormat.FieldType paramFieldType2)
  {
    super(paramFieldType1, MapEntry.a(paramMapEntry), paramFieldType2, MapEntry.b(paramMapEntry));
    this.a = paramDescriptor;
    this.b = new MapEntry.Metadata.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapEntry.Metadata
 * JD-Core Version:    0.7.0.1
 */